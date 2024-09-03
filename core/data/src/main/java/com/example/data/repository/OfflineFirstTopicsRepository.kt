/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.data.repository

import android.util.Log
import com.example.data.Synchronizer
import com.example.data.changeListSync
import com.example.data.model.asEntity
import com.example.database.dao.TopicDao
import com.example.database.model.TopicEntity
import com.example.database.model.asExternalModel
import com.example.model.data.Topic
import com.example.network.NetworkDataSource
import com.example.network.NiaNetworkDataSource
import com.example.network.model.NetworkChangeList
import com.example.network.model.NetworkTopic
import com.google.samples.apps.nowinandroid.core.datastore.ChangeListVersions
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Disk storage backed implementation of the [TopicsRepository].
 * Reads are exclusively from local storage to support offline access.
 */
internal class OfflineFirstTopicsRepository @Inject constructor(
    private val topicDao: TopicDao,
    private val network: NiaNetworkDataSource,
    private val network2: NetworkDataSource,
) : TopicsRepository {

    override fun getTopics(): Flow<List<Topic>> =
        topicDao.getTopicEntities()
            .map { it.map(TopicEntity::asExternalModel) }

    override fun getTopic(id: String): Flow<Topic> =
        topicDao.getTopicEntity(id).map { it.asExternalModel() }

    override suspend fun syncWith(synchronizer: Synchronizer): Boolean {
        val changedIds = network.getTopicChangeList(after = 0).map(NetworkChangeList::id)
        val networkTopics = network.getTopics(ids = changedIds)
        Log.d("HADI","modelUpdater OfflineFirstTopicsRepository ${ network2.getPeople()}")
        topicDao.upsertTopics(
            entities = networkTopics.map(NetworkTopic::asEntity),
        )
       return synchronizer.changeListSync(
            versionReader = ChangeListVersions::topicVersion,
            changeListFetcher = { currentVersion ->
                Log.d("NURS","changeListFetcher OfflineFirstTopicsRepository")
                network.getTopicChangeList(after = currentVersion)
            },
            versionUpdater = { latestVersion ->
                copy(topicVersion = latestVersion)
            },
            modelDeleter = topicDao::deleteTopics,
            modelUpdater = { changedIds ->

                val networkTopics = network.getTopics(ids = changedIds)
                topicDao.upsertTopics(
                    entities = networkTopics.map(NetworkTopic::asEntity),
                )

            },
        )
    }
}

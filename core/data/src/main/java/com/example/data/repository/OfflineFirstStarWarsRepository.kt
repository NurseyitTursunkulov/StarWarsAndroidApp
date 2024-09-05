package com.example.data.repository

import android.util.Log
import com.example.data.Synchronizer
import com.example.data.changeListSync
import com.example.data.util.asEntity
import com.example.database.dao.ActorsDao
import com.example.database.dao.FilmsDao
import com.example.database.model.ActorsEntity
import com.example.database.model.FilmsEntity
import com.example.database.model.asExternalModel
import com.example.model.data.Actor
import com.example.model.data.Film
import com.example.network.NetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineFirstStarWarsRepository @Inject constructor(private val remoteDataSource: NetworkDataSource,
                                     private val localActorsDataSource:ActorsDao,
                                     private val localFilmsDataSource: FilmsDao
    ): StarWarsRepository  {
    override fun getActors(): Flow<List<Actor>> {
        return localActorsDataSource.getActorsEntities().map { it.map(ActorsEntity::asExternalModel) }
    }

    override fun getFilms(): Flow<List<Film>> {
        return localFilmsDataSource.getFilmEntities().map { it.map(FilmsEntity::asExternalModel) }
    }

    override suspend fun syncWith(synchronizer: Synchronizer): Boolean {
        return synchronizer.changeListSync {
            val actorDTOList = remoteDataSource.getActors()// todo run in parallel
            Log.d("NURS", "syncWith: $actorDTOList")
            localActorsDataSource.insertActors(actorDTOList.map { it.asEntity() })
            val filmDTOList = remoteDataSource.getFilms()
            localFilmsDataSource.insertFilms(filmDTOList.map { it.asEntity() })
        }
    }
}
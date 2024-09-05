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

package com.example.work.workers

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.tracing.traceAsync
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.OutOfQuotaPolicy
import androidx.work.WorkerParameters
import com.example.common.network.Dispatcher
import com.example.common.network.NiaDispatchers
import com.example.data.Synchronizer
import com.example.data.repository.StarWarsRepository
import com.example.work.initializers.SyncConstraints
import com.example.work.initializers.syncForegroundInfo
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext

/**
 * Syncs the data layer by delegating to the appropriate repository instances with
 * sync functionality.
 */
@HiltWorker
internal class SyncWorker @AssistedInject constructor(
    @Assisted private val appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val starWarsRepository: StarWarsRepository,
    @Dispatcher(NiaDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
//    private val analyticsHelper: AnalyticsHelper,//todo remove
) : CoroutineWorker(appContext, workerParams), Synchronizer {

    init {
        Log.d("HARNI","init SyncWorker $this")
    }

    override suspend fun getForegroundInfo(): ForegroundInfo {
        Log.d("HARNI","SyncWorker getForegroundInfo $this")
        return appContext.syncForegroundInfo()
    }

    override suspend fun doWork(): Result = withContext(ioDispatcher) {
            Log.d("NURS", "69 DO WORK started sync")
            Log.d("HARNI", "SyncWorker 69 DO WORK started sync")
        traceAsync("Sync", 0) {
//            analyticsHelper.logSyncStarted()

            // First sync the repositories in parallel
            val syncedSuccessfully = awaitAll(
                async { starWarsRepository.sync() },
            ).all { it }

//            analyticsHelper.logSyncFinished(syncedSuccessfully)

            if (syncedSuccessfully) {
                Result.success()
            } else {
                Result.retry()
            }
        }
    }

    companion object {
        /**
         * Expedited one time work to sync data on app startup
         */
        fun startUpSyncWork(): OneTimeWorkRequest {
            Log.d("HARNI"," SyncWorker startUpSyncWork")
          return  OneTimeWorkRequestBuilder<DelegatingWorker>()
                .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
                .setConstraints(SyncConstraints)
                .setInputData(SyncWorker::class.delegatedData())
                .build()
        }
    }
}

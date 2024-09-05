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
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import com.example.work.di.HiltWorkerFactoryEntryPoint
import dagger.hilt.android.EntryPointAccessors
import kotlin.reflect.KClass


/**
 * A worker that delegates sync to another [CoroutineWorker] constructed with a [HiltWorkerFactory].
 *
 * This allows for creating and using [CoroutineWorker] instances with extended arguments
 * without having to provide a custom WorkManager configuration that the app module needs to utilize.
 *
 * In other words, it allows for custom workers in a library module without having to own
 * configuration of the WorkManager singleton.
 */
class DelegatingWorker(
    appContext: Context,
    workerParams: WorkerParameters,
) : CoroutineWorker(appContext, workerParams) {

    init {
        Log.d("HARNI","init DelegatingWorker")
    }
    private val workerClassName =
        workerParams.inputData.getString(WORKER_CLASS_NAME) ?: ""

    private val delegateWorker:CoroutineWorker =
        ( EntryPointAccessors.fromApplication<HiltWorkerFactoryEntryPoint>(appContext)
            .hiltWorkerFactory()
            .createWorker(appContext, workerClassName, workerParams)
            as? CoroutineWorker
            ?: throw IllegalArgumentException("Unable to find appropriate worker")
                ).apply {
                    Log.d("HARNI","delegateWorker created $this")
            }


    override suspend fun getForegroundInfo(): ForegroundInfo {
        Log.d("HARNI","DelegatingWorker getForegroundInfo")
        return delegateWorker.getForegroundInfo()
    }

    override suspend fun doWork(): Result {
        Log.d("HARNI","DelegatingWorker doWork")
        return delegateWorker.doWork()
    }
}




private const val WORKER_CLASS_NAME = "RouterWorkerDelegateClassName"

/**
 * Adds metadata to a WorkRequest to identify what [CoroutineWorker] the [DelegatingWorker] should
 * delegate to
 */
internal fun KClass<out CoroutineWorker>.delegatedData() =
    Data.Builder()
        .putString(WORKER_CLASS_NAME, qualifiedName)
        .build()

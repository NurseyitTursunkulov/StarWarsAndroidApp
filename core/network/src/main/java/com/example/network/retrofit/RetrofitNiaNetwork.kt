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

package com.example.network.retrofit

import androidx.tracing.trace
import com.example.network.NetworkDataSource
import com.example.network.model.ActorDTO
import com.example.network.model.ActorsResponse
import com.example.network.model.FilmDTO
import com.example.network.model.FilmResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject
import javax.inject.Singleton

const val FILMS = "films/"
const val PEOPLE = "people/"

private interface NetworkApi {
    @GET(FILMS)
    suspend fun getAllFilms(): FilmResponse

    @GET(PEOPLE)
    suspend fun getAllPeople(): ActorsResponse
}

private const val NIA_BASE_URL = "https://swapi.dev/api/"

/**
 * [Retrofit] backed [NiaNetworkDataSource]
 */
@Singleton
internal class RetrofitNiaNetwork @Inject constructor(
    networkJson: Json,
    okhttpCallFactory: dagger.Lazy<Call.Factory>,
) : NetworkDataSource {

    private val networkApi = trace("RetrofitNiaNetwork") {
        Retrofit.Builder()
            .baseUrl(NIA_BASE_URL)
            // We use callFactory lambda here with dagger.Lazy<Call.Factory>
            // to prevent initializing OkHttp on the main thread.
            .callFactory { okhttpCallFactory.get().newCall(it) }
            .addConverterFactory(
                networkJson.asConverterFactory("application/json".toMediaType()),
            )
            .build()
            .create(NetworkApi::class.java)
    }
    override suspend fun getActors(): List<ActorDTO> {
        return networkApi.getAllPeople().results
    }

    override suspend fun getFilms(): List<FilmDTO> {
        return networkApi.getAllFilms().results
    }
}

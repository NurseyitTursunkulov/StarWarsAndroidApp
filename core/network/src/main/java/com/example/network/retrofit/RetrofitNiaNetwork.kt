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
import com.example.network.NiaNetworkDataSource
import com.example.network.model.FilmDTO
import com.example.network.model.FilmResponse
import com.example.network.model.NetworkChangeList
import com.example.network.model.NetworkNewsResource
import com.example.network.model.NetworkTopic
import com.example.network.model.PeopleResponse
import com.example.network.model.PersonDTO
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Retrofit API declaration for NIA Network API
 */
private interface RetrofitNiaNetworkApi {
    @GET(value = "topics")
    suspend fun getTopics(
        @Query("id") ids: List<String>?,
    ): NetworkResponse<List<NetworkTopic>>

    @GET(value = "newsresources")
    suspend fun getNewsResources(
        @Query("id") ids: List<String>?,
    ): NetworkResponse<List<NetworkNewsResource>>

    @GET(value = "changelists/topics")
    suspend fun getTopicChangeList(
        @Query("after") after: Int?,
    ): List<NetworkChangeList>

    @GET(value = "changelists/newsresources")
    suspend fun getNewsResourcesChangeList(
        @Query("after") after: Int?,
    ): List<NetworkChangeList>
}

const val FILMS = "films/"
const val PEOPLE = "people/"

private interface NetworkApi {
    @GET(FILMS)
    suspend fun getAllFilms(): FilmResponse

    @GET(PEOPLE)
    suspend fun getAllPeople(): PeopleResponse
}

private const val NIA_BASE_URL = "https://swapi.dev/api/"

/**
 * Wrapper for data provided from the [NIA_BASE_URL]
 */
@Serializable
private data class NetworkResponse<T>(
    val data: T,
)

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

//    override suspend fun getTopics(ids: List<String>?): List<NetworkTopic> =
//        networkApi.getTopics(ids = ids).data
//
//    override suspend fun getNewsResources(ids: List<String>?): List<NetworkNewsResource> =
//        networkApi.getNewsResources(ids = ids).data
//
//    override suspend fun getTopicChangeList(after: Int?): List<NetworkChangeList> =
//        networkApi.getTopicChangeList(after = after)
//
//    override suspend fun getNewsResourceChangeList(after: Int?): List<NetworkChangeList> =
//        networkApi.getNewsResourcesChangeList(after = after)

    override suspend fun getPeople(): List<PersonDTO> {
        return networkApi.getAllPeople().results
    }

    override suspend fun getFilms(): List<FilmDTO> {
        return networkApi.getAllFilms().results
    }
}

package com.example.network.model

import kotlinx.serialization.Serializable

@Serializable
data class FilmResponse(
        val count: Int,
        val next: String?,
        val previous: String?,
        val results: List<FilmDTO>
)

@Serializable
data class FilmDTO(
        val title: String,
        val episode_id: Int,
        val opening_crawl: String,
        val director: String,
        val producer: String,
        val release_date: String,
        val characters: List<String>,
        val planets: List<String>,
        val starships: List<String>,
        val vehicles: List<String>,
        val species: List<String>,
        val created: String,
        val edited: String,
        val url: String
)

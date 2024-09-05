package com.example.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.model.data.Film

@Entity(
    tableName = "films",
)
data class FilmsEntity(
    val title: String,
    val opening_crawl: String,
    val director: String,
    val producer: String,
    val release_date: String,
    val created: String,
    val edited: String,
    @PrimaryKey
    val url: String
)

fun FilmsEntity.asExternalModel() = Film(
    title = title,
    openingCrawl = opening_crawl,
    director = director,
    producer = producer,
    releaseDate = release_date,
    created = created,
    edited = edited,
    url = url
)
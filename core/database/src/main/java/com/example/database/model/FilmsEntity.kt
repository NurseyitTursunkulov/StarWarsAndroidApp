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
//    val characters: List<String>,
//    val planets: List<String>,
//    val starships: List<String>,
//    val vehicles: List<String>,
//    val species: List<String>,
    val created: String,
    val edited: String,
    @PrimaryKey
    val url: String
)

fun FilmsEntity.asExternalModel() = Film(
    title = title,
    opening_crawl = opening_crawl,
    director = director,
    producer = producer,
    release_date = release_date,
//    characters = characters,
//    planets = planets,
//    starships = starships,
//    vehicles = vehicles,
//    species = species,
    created = created,
    edited = edited,
    url = url
)
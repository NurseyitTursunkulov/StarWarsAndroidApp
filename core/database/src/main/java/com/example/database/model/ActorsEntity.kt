package com.example.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.model.data.Actor

@Entity(
    tableName = "actors",
)
data class ActorsEntity(
    val name: String,
    val height: String,
    val mass: String,
    val birth_year: String,
    val gender: String,
    val homeworld: String,
    val created: String,
    val edited: String,
    @PrimaryKey
    val url: String
)

fun ActorsEntity.asExternalModel() = Actor(
    name = this.name,
    height = this.height,
    mass = this.mass,
    birthYear = this.birth_year,
    gender = this.gender,
    homeworld = this.homeworld,
    created = this.created,
    edited = this.edited,
    url = this.url
)


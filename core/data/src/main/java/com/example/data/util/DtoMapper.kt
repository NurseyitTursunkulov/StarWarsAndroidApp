package com.example.data.util

import com.example.database.model.ActorsEntity
import com.example.database.model.FilmsEntity
import com.example.network.model.ActorDTO
import com.example.network.model.FilmDTO

fun ActorDTO.asEntity() = ActorsEntity(
    name = name,
    height = height,
    mass = mass,
    birth_year = birth_year,
    gender = gender,
    homeworld = homeworld,
    created = created,
    edited = edited,
    url = url,
)

fun FilmDTO.asEntity() = FilmsEntity(
    title = title,
    opening_crawl = opening_crawl,
    director = director,
    producer = producer,
    release_date = release_date,
    created = created,
    edited = edited,
    url = url,
)
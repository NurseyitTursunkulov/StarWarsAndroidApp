package com.example.data.repository

import com.example.data.Syncable
import com.example.model.data.Actor
import com.example.model.data.Film
import kotlinx.coroutines.flow.Flow

interface StarWarsRepository : Syncable {
    fun getActors(): Flow<List<Actor>>
    fun getFilms():Flow<List<Film>>
}
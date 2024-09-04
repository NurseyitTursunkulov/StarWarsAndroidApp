package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.dao.ActorsDao
import com.example.database.dao.FilmsDao
import com.example.database.model.ActorsEntity
import com.example.database.model.FilmsEntity


@Database(
    entities = [
        ActorsEntity::class,
        FilmsEntity::class
    ],
    version = 1,
)
internal abstract class Database : RoomDatabase() {
    abstract fun actorsDao(): ActorsDao
    abstract fun filmsDao(): FilmsDao
}
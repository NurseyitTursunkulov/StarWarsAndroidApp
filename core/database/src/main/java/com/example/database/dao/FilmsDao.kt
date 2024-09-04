package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.database.model.ActorsEntity
import com.example.database.model.FilmsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFilms(films: List<FilmsEntity>)

    @Upsert
    suspend fun upsertFilms(films: List<FilmsEntity>)

    @Query(
        value = """
        SELECT * FROM films
        WHERE url IN (:ids)
    """,
    )
    fun getFilmsEntities(ids: Set<String>): Flow<List<FilmsEntity>>

    @Query(value = "SELECT * FROM films")
    fun getFilmEntities(): Flow<List<FilmsEntity>>

    @Query(
        value = """
        SELECT * FROM actors
        WHERE url = :id
    """,
    )
    fun getFilmEntity(id: String): Flow<ActorsEntity>
}
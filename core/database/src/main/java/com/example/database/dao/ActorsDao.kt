package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.database.model.ActorsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ActorsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertActors(actors: List<ActorsEntity>)

    @Upsert
    suspend fun upsertActors(actors: List<ActorsEntity>)

    @Query(
        value = """
        SELECT * FROM actors
        WHERE url IN (:ids)
    """,
    )
    fun getActorsEntities(ids: Set<String>): Flow<List<ActorsEntity>>

    @Query(value = "SELECT * FROM actors")
    fun getActorsEntities(): Flow<List<ActorsEntity>>

    @Query(
        value = """
        SELECT * FROM actors
        WHERE url = :id
    """,
    )
    fun getActorEntity(id: String): Flow<ActorsEntity>
}
package com.example.domain

import com.example.data.repository.StarWarsRepository
import com.example.model.data.Actor
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * this layer seems to be overengineering, but was added only for the future.
 */
class GetActorsUseCase @Inject constructor(private val starWarsRepository: StarWarsRepository)  {
    operator fun invoke(): Flow<List<Actor>> {
        return starWarsRepository.getActors()
    }
}
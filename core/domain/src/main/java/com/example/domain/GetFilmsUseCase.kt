package com.example.domain

import com.example.data.repository.StarWarsRepository
import com.example.model.data.Film
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * this layer seems to be overengineering, but was added only for the future.
 */
class GetFilmsUseCase @Inject constructor(private val starWarsRepository: StarWarsRepository) {
    operator fun invoke(): Flow<List<Film>> {
        return starWarsRepository.getFilms()
    }
}
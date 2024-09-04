package com.example.foryou

import com.example.model.data.Actor

sealed interface ActorsUiState {
    data object Loading : ActorsUiState
    data object Error : ActorsUiState
    data class Success(val actors: List<Actor>) : ActorsUiState

}
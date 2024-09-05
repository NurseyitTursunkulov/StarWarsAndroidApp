package com.example.films

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.GetFilmsUseCase
import com.example.model.data.Film
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    getFilmsUseCase: GetFilmsUseCase,
) : ViewModel() {

    val uiState: StateFlow<FilmsUiState> =
        getFilmsUseCase().map<List<Film>, FilmsUiState>(FilmsUiState::Films)
            .onStart { emit(FilmsUiState.Loading) }
            .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = FilmsUiState.Loading,
        )
}

sealed interface FilmsUiState {
    data object Loading : FilmsUiState
    data class Films(
        val films: List<Film>,
    ) : FilmsUiState

    data class Error(val message: String) : FilmsUiState
}
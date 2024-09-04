package com.example.foryou

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.util.SyncManager
import com.example.domain.GetActorsUseCase
import com.example.model.data.Actor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ActorsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    syncManager: SyncManager,
    getActorsUseCase: GetActorsUseCase,
) : ViewModel() {
    val isSyncing = syncManager.isSyncing
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false,
        )

    val actorsUiState: StateFlow<ActorsUiState> =
        getActorsUseCase().map<List<Actor>, ActorsUiState>(ActorsUiState::Success)
            .onStart { emit(ActorsUiState.Loading) }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = ActorsUiState.Loading,
            )
}
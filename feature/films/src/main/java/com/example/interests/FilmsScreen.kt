package com.example.interests

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.designsystem.component.NiaLoadingWheel
import com.example.designsystem.icon.StarWarsIcon
import com.example.ui.StarWarsResourceCardExpanded

@Composable
fun FilmsRoute(
    modifier: Modifier = Modifier,
    viewModel: FilmsViewModel = hiltViewModel(),
){
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    FilmsScreen(
        uiState = uiState,
        modifier = modifier,
    )
}

@Composable
internal fun FilmsScreen(
    uiState: FilmsUiState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        when (uiState) {
            is FilmsUiState.Error -> {
                Text(text = stringResource(id = R.string.feature_interests_empty_header))
            }
            is FilmsUiState.Films -> {
                Box(
                    modifier = modifier
                        .fillMaxSize(),
                ) {
                    LazyColumn {
                        items(uiState.films) { film ->

                            Text(text = film.title)
                            StarWarsResourceCardExpanded(
                                title = film.title,
                                descriptions = listOf(
                                    film.opening_crawl,
                                    "director ${film.director}",
                                    "producer ${film.producer}",
                                    "release date ${film.release_date}"
                                ),
                                onClick = { /* ... */ },
                                modifier = Modifier
                                    .padding(horizontal =8.dp)
                                    .animateItem(),
                                imageVector = StarWarsIcon
                            )
                            Column {
                                Spacer(modifier = Modifier.height(8.dp))
                                Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.safeDrawing))
                            }

                        }
                    }
                }
            }
            FilmsUiState.Loading -> {
                NiaLoadingWheel(
                    modifier = modifier,
                    contentDesc = stringResource(id = R.string.feature_interests_loading),
                )
            }
        }
    }
}
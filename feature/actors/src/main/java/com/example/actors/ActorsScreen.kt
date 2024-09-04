package com.example.actors

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.designsystem.component.NiaOverlayLoadingWheel
import com.example.designsystem.icon.Icon_Dark_Vaider
import com.example.ui.StarWarsResourceCardExpanded

@Composable
internal fun ActorsRoute(
    modifier: Modifier = Modifier,
    viewModel: ActorsViewModel = hiltViewModel(),
) {
    val actorsUiState = viewModel.actorsUiState.collectAsStateWithLifecycle()
    val isSyncing by viewModel.isSyncing.collectAsStateWithLifecycle()
    ActorsScreen(
        actorsUiState = actorsUiState.value,
        isSyncing = isSyncing,
        modifier = modifier
    )
}

@Composable
internal fun ActorsScreen(
    actorsUiState: ActorsUiState,
    isSyncing: Boolean,
    modifier: Modifier = Modifier,
) {
    when (actorsUiState) {
        ActorsUiState.Loading -> Unit
        is ActorsUiState.Success -> {
            Box(
                modifier = modifier
                    .fillMaxSize(),
            ) {
                LazyColumn {
                    items(actorsUiState.actors) { userNewsResource ->

//                        Text(text = userNewsResource.name)
                        Spacer(modifier = Modifier.height(2.dp))
                        StarWarsResourceCardExpanded(
                            title = userNewsResource.name,
                            descriptions = listOf(
                                "height ${userNewsResource.height}",
                                "mass ${userNewsResource.mass}",
                                "birth year ${userNewsResource.birth_year}",
                                "gender ${userNewsResource.gender}"
                            ),
                            onClick = { /* ... */ },
                            modifier = Modifier
                                .padding(horizontal =8.dp)
                                .animateItem(),
                            imageVector = Icon_Dark_Vaider
                        )
                        Column {
                            Spacer(modifier = Modifier.height(8.dp))
                            Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.safeDrawing))
                        }

                    }
                }
                AnimatedVisibility(
                    visible = isSyncing,
                    enter = slideInVertically(
                        initialOffsetY = { fullHeight -> -fullHeight },
                    ) + fadeIn(),
                    exit = slideOutVertically(
                        targetOffsetY = { fullHeight -> -fullHeight },
                    ) + fadeOut(),
                ) {
                    val loadingContentDescription =
                        "stringResource(id = R.string.feature_foryou_loading)"
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        NiaOverlayLoadingWheel(
                            modifier = Modifier
                                .align(Alignment.Center),
                            contentDesc = loadingContentDescription,
                        )
                    }
                }
            }
        }

        ActorsUiState.Error -> TODO()
    }

}
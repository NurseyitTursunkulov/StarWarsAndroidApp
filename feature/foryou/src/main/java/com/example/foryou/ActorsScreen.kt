package com.example.foryou

import android.content.ClipData
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.view.View
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.draganddrop.dragAndDropSource
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draganddrop.DragAndDropTransferData
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.designsystem.component.NiaOverlayLoadingWheel
import com.example.model.data.Actor
import com.example.ui.BookmarkButton
import com.example.ui.NewsResourceShortDescription
import com.example.ui.NewsResourceTitle
import com.example.ui.NotificationDot
import com.example.ui.R
import com.example.ui.starWarCardHeaderImage

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

@OptIn(ExperimentalFoundationApi::class)
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
                        val context = LocalContext.current
                        val backgroundColor = MaterialTheme.colorScheme.background.toArgb()

                        Text(text = userNewsResource.name)
                        NewsResourceCardExpanded(
                            userNewsResource = userNewsResource,
                            onClick = {
                            },
                            onTopicClick = { },
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                                .animateItem(),
                        )
                        Column {
                            Spacer(modifier = Modifier.height(8.dp))
                            // Add space for the content to clear the "offline" snackbar.
                            // TODO: Check that the Scaffold handles this correctly in NiaApp
                            // if (isOffline) Spacer(modifier = Modifier.height(48.dp))
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
                    val loadingContentDescription = "stringResource(id = R.string.feature_foryou_loading)"
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
//                            .padding(top = 8.dp),
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

@OptIn(ExperimentalFoundationApi::class)
fun LazyStaggeredGridScope.newsFeed(
    feedState: ActorsUiState,
) {
    when (feedState) {
        ActorsUiState.Loading -> Unit
        is ActorsUiState.Success -> {
            items(
                items = feedState.actors,
                key = { it.url },
                contentType = { "actorItem" },
            ) { userNewsResource ->
                val context = LocalContext.current
                val backgroundColor = MaterialTheme.colorScheme.background.toArgb()

                NewsResourceCardExpanded(
                    userNewsResource = userNewsResource,
                    onClick = {
                    },
                    onTopicClick = { },
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .animateItemPlacement(),
                )
            }
        }

        ActorsUiState.Error -> TODO()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NewsResourceCardExpanded(
    userNewsResource: Actor,
    onClick: () -> Unit,
    onTopicClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val clickActionLabel = stringResource(R.string.core_ui_card_tap_action)
    val sharingLabel = stringResource(R.string.core_ui_feed_sharing)
    val sharingContent = stringResource(
        R.string.core_ui_feed_sharing_data,
        userNewsResource.name,
        userNewsResource.url,
    )

    val dragAndDropFlags = if (VERSION.SDK_INT >= VERSION_CODES.N) {
        View.DRAG_FLAG_GLOBAL
    } else {
        0
    }

    Card(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        // Use custom label for accessibility services to communicate button's action to user.
        // Pass null for action to only override the label and not the actual action.
        modifier = modifier.semantics {
            onClick(label = clickActionLabel, action = null)
        },
    ) {
        Column {
            Row {
                starWarCardHeaderImage(null,R.drawable.dark_veider)
            }
            Box(
                modifier = Modifier.padding(16.dp),
            ) {
                Column {
                    Spacer(modifier = Modifier.height(12.dp))
                    Row {
                        NewsResourceTitle(
                            userNewsResource.name,
                            modifier = Modifier
                                .fillMaxWidth((.8f))
                                .dragAndDropSource {
                                    detectTapGestures(
                                        onLongPress = {
                                            startTransfer(
                                                DragAndDropTransferData(
                                                    ClipData.newPlainText(
                                                        sharingLabel,
                                                        sharingContent,
                                                    ),
                                                    flags = dragAndDropFlags,
                                                ),
                                            )
                                        },
                                    )
                                },
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        BookmarkButton(false, {  })
                    }
                    Spacer(modifier = Modifier.height(14.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
//                        if (!hasBeenViewed) {
                            NotificationDot(
                                color = MaterialTheme.colorScheme.tertiary,
                                modifier = Modifier.size(8.dp),
                            )
                            Spacer(modifier = Modifier.size(6.dp))
//                        }
//                        NewsResourceMetaData(userNewsResource.publishDate, userNewsResource.type)
                    }
                    Spacer(modifier = Modifier.height(14.dp))
                    NewsResourceShortDescription(userNewsResource.name)
                    Spacer(modifier = Modifier.height(12.dp))
//                    NewsResourceTopics(
//                        topics = userNewsResource.followableTopics,
//                        onTopicClick = onTopicClick,
//                    )
                }
            }
        }
    }
}
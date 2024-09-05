package com.example.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.example.designsystem.icon.Icon_Dark_Vaider

@Composable
fun starWarCardHeaderImage(
    headerImageUrl: String?,
     imageVector: ImageVector,
) {
    var isLoading by remember { mutableStateOf(true) }
    var isError by remember { mutableStateOf(false) }
    val imageLoader = rememberAsyncImagePainter(
        model = headerImageUrl,
        onState = { state ->
            isLoading = state is AsyncImagePainter.State.Loading
            isError = state is AsyncImagePainter.State.Error
        },
    )
    val isLocalInspection = LocalInspectionMode.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        contentAlignment = Alignment.Center,
    ) {
        if (isLoading) {
            // Display a progress bar while loading
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(80.dp),
                color = MaterialTheme.colorScheme.tertiary,
            )
        }

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            contentScale = ContentScale.FillHeight,
            painter = if (isError.not() && !isLocalInspection) {
                imageLoader
            } else {
                rememberVectorPainter(image = imageVector)
            },
            contentDescription = null,
        )
    }
}

@Composable
fun StarWarsResourceCardExpanded(
    //    userNewsResource: Actor,
    title: String,
    descriptions: List<String>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    imageVector: ImageVector
) {
    Card(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        modifier = modifier
    ) {
        Column {
            Row {
                starWarCardHeaderImage(null, imageVector)
            }
            Box(
                modifier = Modifier.padding(16.dp)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Row {
//                        NewsResourceTitle(
//                            title,
//                            modifier = Modifier
////                                .fillMaxWidth(0.8f)
//                        )
//                        Spacer(modifier = Modifier.weight(1f))
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    descriptions.forEach { description ->
                        Text(description,
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 5,
                            style = MaterialTheme.typography.bodyLarge)
                        Spacer(modifier = Modifier.height(6.dp))
                    }
                }
            }
        }
    }
}

@Composable
@Preview
private fun cardPreview() {
    starWarCardHeaderImage(null,Icon_Dark_Vaider)
}

@Preview(showBackground = true)
@Composable
fun StarWarsResourceCardExpandedPreview() {
    StarWarsResourceCardExpanded(title = "Darth Vader",
        descriptions = listOf(
            "height 202",
            "mass 136",
            "birth year 41.9BBY",
            "gender male"
        ),
        onClick = { },
        modifier =Modifier.padding(8.dp),
        imageVector = Icon_Dark_Vaider
    )
}
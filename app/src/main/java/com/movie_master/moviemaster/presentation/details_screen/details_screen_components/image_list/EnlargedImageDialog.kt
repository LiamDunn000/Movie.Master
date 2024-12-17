package com.movie_master.moviemaster.presentation.details_screen.details_screen_components.image_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import com.movie_master.moviemaster.data.details_screen_data.details_screen_states.detailsScreenStates
import com.movie_master.moviemaster.functionality.user_interface_operations.userInterfaceOperations

@Composable
fun EnlargedImageDialog() {

    if (detailsScreenStates.isImageEnlarged) {
        Dialog(
            onDismissRequest = { detailsScreenStates.isImageEnlarged = false }
        ) {
            Box(
                modifier = Modifier
                    .clickable { detailsScreenStates.isImageEnlarged = false }
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = userInterfaceOperations.determineMediaBackdropImageUrl(
                        mediaItem = detailsScreenStates.selectedImage
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}
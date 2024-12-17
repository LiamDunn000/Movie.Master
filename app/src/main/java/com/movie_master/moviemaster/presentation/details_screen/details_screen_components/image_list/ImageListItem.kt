package com.movie_master.moviemaster.presentation.details_screen.details_screen_components.image_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.movie_master.moviemaster.data.details_screen_data.details_screen_dimensions.DetailsScreenDimensions
import com.movie_master.moviemaster.data.details_screen_data.details_screen_states.detailsScreenStates
import com.movie_master.moviemaster.functionality.user_interface_operations.userInterfaceOperations

@Composable
fun ImageListItem(
    modifier: Modifier = Modifier,
    dimensions: DetailsScreenDimensions = DetailsScreenDimensions(),
    mediaItem: Any,
) {

    // Image List Item
    Card(
        modifier.clickable {
            detailsScreenStates.isImageEnlarged = true
            detailsScreenStates.selectedImage = mediaItem},
        elevation = CardDefaults.cardElevation(dimensions.standardDetailsListItemElevation.dp),
        shape = RoundedCornerShape(dimensions.detailsScreenHeaderImageCornerRadius.dp),
    ) {
        Box(
            modifier.size(dimensions.imageListItemSize.dp)
        ) {
            AsyncImage(
                model = userInterfaceOperations.determineMediaBackdropImageUrl(mediaItem = mediaItem),
                contentDescription = null,
                modifier = Modifier,
                contentScale = ContentScale.Crop
            )
        }
    }
}
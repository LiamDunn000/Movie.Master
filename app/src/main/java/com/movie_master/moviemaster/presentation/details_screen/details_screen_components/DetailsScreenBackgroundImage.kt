package com.movie_master.moviemaster.presentation.details_screen.details_screen_components

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import com.movie_master.moviemaster.data.details_screen_data.details_screen_colors.DetailsScreenColors
import com.movie_master.moviemaster.data.details_screen_data.details_screen_colors.detailsScreenColors
import com.movie_master.moviemaster.data.details_screen_data.details_screen_dimensions.DetailsScreenDimensions
import com.movie_master.moviemaster.functionality.user_interface_operations.userInterfaceOperations

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun DetailsScreenBackgroundImage(
    dimensions: DetailsScreenDimensions = DetailsScreenDimensions(),
    colors: DetailsScreenColors = detailsScreenColors,
) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = colors.detailsScreenBackGroundColor
        ),
        shape = RectangleShape,
        modifier = Modifier
            .zIndex(1f)
            .fillMaxWidth()
            .height(dimensions.detailsScreenHeaderBackgroundImageHeight.dp)
    ) {

        Box(
            modifier = Modifier
                .zIndex(1f)
                .fillMaxSize()
        ) {

            Box(
                modifier = Modifier
                    .zIndex(2f)
                    .fillMaxSize()
            ) {

                // Background Image
                AsyncImage(
                    model = userInterfaceOperations.determineMediaBackgroundImageUrl(),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                )
            }

            Box(
                modifier = Modifier
                    .zIndex(3f)
                    .background(color = colors.detailsScreenImageShaderColor)
                    .fillMaxSize()
            )
        }

        DetailsHeaderDetails()
    }
}
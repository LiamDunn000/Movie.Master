package com.movie_master.moviemaster.presentation.details_screen.details_screen_components

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.movie_master.moviemaster.data.details_screen_data.details_screen_colors.DetailsScreenColors
import com.movie_master.moviemaster.data.details_screen_data.details_screen_colors.detailsScreenColors
import com.movie_master.moviemaster.data.details_screen_data.details_screen_dimensions.DetailsScreenDimensions

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun DetailsScreenHeader(
    dimensions: DetailsScreenDimensions = DetailsScreenDimensions(),
    colors: DetailsScreenColors = detailsScreenColors,
) {

    Box(
        modifier = Modifier
            .background(color = colors.detailsScreenBackGroundColor)
            .fillMaxWidth()
            .height(dimensions.detailsScreenHeaderBackgroundImageHeight.dp)
    ){

        // Layer One
        DetailsScreenBackgroundImage()

        // Layer Three
        DetailsHeaderDetails()

    }
}
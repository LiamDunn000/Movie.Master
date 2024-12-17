package com.movie_master.moviemaster.presentation.home_screen.home_screen_components

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.movie_master.moviemaster.data.home_screen_data.home_screen_data_dimensions.HomeScreenDimensions
import com.movie_master.moviemaster.presentation.home_screen.home_screen_components.large_media_selection_list_item.LargeMediaSelectionListItem

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun MediaSelectionList(
    dimensions: HomeScreenDimensions = HomeScreenDimensions(),
    navController: NavController,
    itemSize: String,
    mediaList: List<Any>,
    ) {

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensions.movieSelectionListHeight.dp),
        horizontalArrangement = Arrangement.spacedBy(dimensions.movieSelectionListSpacing.dp),
    ) {

        // Now Playing List
        items(mediaList) { mediaItem ->

            when (itemSize) {
                "Large" -> LargeMediaSelectionListItem(navController = navController, mediaItem = mediaItem)
                "Standard" -> MediaSelectionListItem(navController = navController, mediaItem = mediaItem)
            }
        }
    }
}
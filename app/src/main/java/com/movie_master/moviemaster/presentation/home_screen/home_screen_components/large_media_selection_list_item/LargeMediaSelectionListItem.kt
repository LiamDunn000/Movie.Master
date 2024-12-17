package com.movie_master.moviemaster.presentation.home_screen.home_screen_components.large_media_selection_list_item

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.movie_master.moviemaster.data.home_screen_data.home_screen_data_dimensions.HomeScreenDimensions
import com.movie_master.moviemaster.functionality.api_operations.manageProfileOperations
import com.movie_master.moviemaster.functionality.navigation_operations.navigationOperations
import com.movie_master.moviemaster.presentation.home_screen.home_screen_components.large_media_selection_list_item.large_media_selection_list_item_components.LargeMediaSelectionListItemBackgroundImage
import com.movie_master.moviemaster.presentation.home_screen.home_screen_components.large_media_selection_list_item.large_media_selection_list_item_components.LargeMediaSelectionListItemDetails

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun LargeMediaSelectionListItem(
    dimensions: HomeScreenDimensions = HomeScreenDimensions(),
    navController: NavController,
    mediaItem: Any
) {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .pointerInput(mediaItem) {
                detectTapGestures (
                    onTap = {
                        navigationOperations.navigateToDetailsScreen(
                            context = context,
                            navController = navController,
                            mediaItem = mediaItem)
                    },
                    onLongPress = { manageProfileOperations.selectMediaToAddToList(mediaItem = mediaItem) },
                    onDoubleTap = {}
                )

            }
            .width(dimensions.largeMediaSelectionListItemWidth.dp)
            .height(dimensions.largeMediaSelectionListItemHeight.dp)
    ){

        // Layer One
        LargeMediaSelectionListItemBackgroundImage(mediaItem = mediaItem)

        // Layer Three
        LargeMediaSelectionListItemDetails(mediaItem = mediaItem)

    }
}
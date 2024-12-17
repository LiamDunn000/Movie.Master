package com.movie_master.moviemaster.presentation.media_search_bar.media_search_bar_components

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_colors.MediaSearchBarColors
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_colors.mediaSearchBarColors
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_dimensions.MediaSearchBarDimensions
import com.movie_master.moviemaster.functionality.api_operations.manageProfileOperations
import com.movie_master.moviemaster.functionality.api_operations.searchDataOperations
import com.movie_master.moviemaster.functionality.navigation_operations.navigationOperations
import com.movie_master.moviemaster.functionality.user_interface_operations.UserInterfaceOperations
import com.movie_master.moviemaster.functionality.user_interface_operations.userInterfaceOperations

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun SearchResultListItem(
    dimensions: MediaSearchBarDimensions = MediaSearchBarDimensions(),
    colors: MediaSearchBarColors = mediaSearchBarColors,
    operations: UserInterfaceOperations = userInterfaceOperations,
    navController: NavController,
    mediaItem: Any,
    details: String,
) {

    val context = LocalContext.current

    // Search Result List Item Layout
    Row(
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        navigationOperations.navigateToDetailsScreen(
                            context = context,
                            navController = navController,
                            mediaItem = mediaItem
                        )
                        searchDataOperations.closeMediaSearchBar()
                    },
                    onLongPress = { manageProfileOperations.selectMediaToAddToList(mediaItem = mediaItem) },
                    onDoubleTap = {})
            }
            .border(
                width = dimensions.searchResultListItemBorderWidth.dp,
                color = colors.searchResultListItemBorderColor,
            )
            .fillMaxWidth()
            .height(dimensions.searchResultListItemHeight.dp)
            .padding(dimensions.searchResultListItemPadding.dp),
        horizontalArrangement = Arrangement.spacedBy(dimensions.searchResultListItemSpacing.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

       // Search Result List Item Image
       AsyncImage(
           model = operations.determineMediaImageUrl(mediaItem = mediaItem),
           contentDescription = null,
       )

        Column {

            // Search Result List Item Title
            Text(
                text = operations.determineMediaTitle(mediaItem = mediaItem),
                color = colors.searchResultItemTitleTextColor,
                fontSize = dimensions.searchResultListItemTitleFontSize.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.basicMarquee())

            // Search Result List Item Details
            Text(
                text = details,
                color = colors.searchResultItemDetailsTextColor,
                fontSize = dimensions.searchResultListItemDetailsFontSize.sp,
                modifier = Modifier.basicMarquee()
                )
        }
    }
}
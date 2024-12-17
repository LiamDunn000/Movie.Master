package com.movie_master.moviemaster.presentation.details_screen.details_screen_components.details_screen_header.image_list

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.movie_master.moviemaster.R
import com.movie_master.moviemaster.data.details_screen_data.details_screen_dimensions.DetailsScreenDimensions
import com.movie_master.moviemaster.data.details_screen_data.details_screen_states.DetailsScreenStates
import com.movie_master.moviemaster.data.details_screen_data.details_screen_states.detailsScreenStates
import com.movie_master.moviemaster.data.shared_data.sharedStates
import com.movie_master.moviemaster.functionality.api_operations.fetchDataOperations
import com.movie_master.moviemaster.functionality.user_interface_operations.userInterfaceOperations
import com.movie_master.moviemaster.presentation.details_screen.details_screen_components.details_screen_header.DetailsScreenCategoryHeader

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun ImageList(
    modifier: Modifier = Modifier,
    dimensions: DetailsScreenDimensions = DetailsScreenDimensions(),
    states: DetailsScreenStates = detailsScreenStates,
) {

    val context = LocalContext.current

    fetchDataOperations.getImagesList(context = context, mediaItem = sharedStates.selectedMediaItem)

    // Image List Layout
    Column(
        modifier.padding(dimensions.detailsScreenCategoryPadding.dp)
    ) {

        // Image List Header
        DetailsScreenCategoryHeader(icon = R.drawable.image_icon, text = "Images")

        // Image List
        LazyRow(
            modifier
                .fillMaxWidth()
                .padding(vertical = dimensions.standardDetailsListItemPadding.dp),
            horizontalArrangement = Arrangement.spacedBy(dimensions.categoryListSpacing.dp)
        ) {

            items(userInterfaceOperations.determineMediaBackdropImageList(
                movieImageList = states.movieImageList,
                tvSeriesImageList = states.tvSeriesImageList,
                celebrityImageList = states.celebrityImageList
            )) { backdrop ->

                ImageListItem(mediaItem = backdrop)
            }
        }
    }
}
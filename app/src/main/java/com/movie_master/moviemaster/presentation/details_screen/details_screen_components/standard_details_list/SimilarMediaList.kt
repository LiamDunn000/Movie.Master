package com.movie_master.moviemaster.presentation.details_screen.details_screen_components.standard_details_list

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.movie_master.moviemaster.R
import com.movie_master.moviemaster.data.api_data.celebrity._celebrity.Celebrity
import com.movie_master.moviemaster.data.api_data.movie.movie_credits.MovieCast
import com.movie_master.moviemaster.data.api_data.tv_series.tv_credits.TvSeriesCast
import com.movie_master.moviemaster.data.details_screen_data.details_screen_dimensions.DetailsScreenDimensions
import com.movie_master.moviemaster.data.shared_data.sharedStates
import com.movie_master.moviemaster.functionality.user_interface_operations.userInterfaceOperations
import com.movie_master.moviemaster.presentation.details_screen.details_screen_components.DetailsScreenCategoryHeader

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun SimilarMediaList(
    modifier: Modifier = Modifier,
    dimensions: DetailsScreenDimensions = DetailsScreenDimensions(),
    navController: NavController
) {

// Conditional That Determine If Media Item Is A Celebrity
    if (sharedStates.selectedMediaItem is Celebrity || sharedStates.selectedMediaItem
                is MovieCast || sharedStates.selectedMediaItem is TvSeriesCast
    ) { return } else {

        Column(
            modifier.padding(dimensions.detailsScreenCategoryPadding.dp)
        ) {

            // Category Header
            DetailsScreenCategoryHeader(icon = R.drawable.like_icon, text = "Users Also Liked")

                // Similar Media List
                LazyRow(
                    modifier.padding(vertical =  dimensions.standardDetailsListItemPadding.dp),
                    horizontalArrangement = Arrangement.spacedBy(dimensions.categoryListSpacing.dp)
                ) {

                    items(userInterfaceOperations.determineSimilarMedia()) { mediaItem ->

                        // Similar Media List Item
                        StandardDetailsListItem(
                            navController = navController,
                            mediaItem = mediaItem
                        )
                    }}
            }
        }
}
package com.movie_master.moviemaster.presentation.details_screen.details_screen_components.details_screen_header.standard_details_list

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.movie_master.moviemaster.R
import com.movie_master.moviemaster.data.api_data.movie._movie.Movie
import com.movie_master.moviemaster.data.api_data.tv_series._tv_series.TvSeries
import com.movie_master.moviemaster.data.details_screen_data.details_screen_dimensions.DetailsScreenDimensions
import com.movie_master.moviemaster.data.details_screen_data.details_screen_states.DetailsScreenStates
import com.movie_master.moviemaster.data.details_screen_data.details_screen_states.detailsScreenStates
import com.movie_master.moviemaster.data.shared_data.sharedStates
import com.movie_master.moviemaster.functionality.api_operations.fetchDataOperations
import com.movie_master.moviemaster.functionality.user_interface_operations.userInterfaceOperations
import com.movie_master.moviemaster.presentation.details_screen.details_screen_components.details_screen_header.DetailsScreenCategoryHeader

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun CreditsList(
    modifier: Modifier = Modifier,
    dimensions: DetailsScreenDimensions = DetailsScreenDimensions(),
    states: DetailsScreenStates = detailsScreenStates,
    navController: NavController
) {

    val context = LocalContext.current

    fetchDataOperations.getCreditsDetails(context = context, mediaItem = sharedStates.selectedMediaItem)

    Column(
        modifier.padding(dimensions.detailsScreenCategoryPadding.dp)
    ) {

        DetailsScreenCategoryHeader(
            icon = R.drawable.age_rating_icon,
            text = when (sharedStates.selectedMediaItem) {
                is Movie -> "Cast"
                is TvSeries -> "Cast"
                else -> "Known For"
            }
        )

        LazyRow(
            modifier
                .padding(vertical = dimensions.detailsScreenListSpacing.dp)
                .fillMaxWidth()
                .height(dimensions.standardDetailsListItemHeight.dp),
            horizontalArrangement = Arrangement.spacedBy(dimensions.categoryListSpacing.dp)
        ) {
            items(
                userInterfaceOperations.determineMediaCreditsList(
                    movieCreditsList = states.movieCreditsList,
                    tvSeriesCreditsList = states.tvSeriesCreditsList,
                    celebrityMovieCredits = states.celebrityMovieCreditsList
                )
            ) { mediaItem ->

                StandardDetailsListItem(mediaItem = mediaItem, navController = navController)
            }

            items(states.celebrityTvSeriesCreditsList.cast) { mediaItem ->
                StandardDetailsListItem(mediaItem = mediaItem, navController = navController)
            }

        }
    }
}

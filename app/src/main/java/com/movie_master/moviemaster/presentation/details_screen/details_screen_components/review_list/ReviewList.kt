package com.movie_master.moviemaster.presentation.details_screen.details_screen_components.review_list

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.movie_master.moviemaster.R
import com.movie_master.moviemaster.data.api_data.celebrity._celebrity.Celebrity
import com.movie_master.moviemaster.data.api_data.celebrity.celebrity_movie_credits.CelebrityMovieCast
import com.movie_master.moviemaster.data.api_data.celebrity.celebrity_tv_credits.CelebrityTvCast
import com.movie_master.moviemaster.data.api_data.movie._movie.Movie
import com.movie_master.moviemaster.data.api_data.movie.movie_credits.MovieCast
import com.movie_master.moviemaster.data.api_data.tv_series._tv_series.TvSeries
import com.movie_master.moviemaster.data.api_data.tv_series.tv_credits.TvSeriesCast
import com.movie_master.moviemaster.data.details_screen_data.details_screen_colors.DetailsScreenColors
import com.movie_master.moviemaster.data.details_screen_data.details_screen_colors.detailsScreenColors
import com.movie_master.moviemaster.data.details_screen_data.details_screen_dimensions.DetailsScreenDimensions
import com.movie_master.moviemaster.data.details_screen_data.details_screen_states.DetailsScreenStates
import com.movie_master.moviemaster.data.details_screen_data.details_screen_states.detailsScreenStates
import com.movie_master.moviemaster.data.shared_data.sharedStates
import com.movie_master.moviemaster.functionality.api_operations.fetchDataOperations
import com.movie_master.moviemaster.functionality.user_interface_operations.userInterfaceOperations
import com.movie_master.moviemaster.presentation.details_screen.details_screen_components.DetailsScreenCategoryHeader

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun ReviewList(
    modifier: Modifier = Modifier,
    dimensions: DetailsScreenDimensions = DetailsScreenDimensions(),
    colors: DetailsScreenColors = detailsScreenColors,
    states: DetailsScreenStates = detailsScreenStates,
) {

    val context = LocalContext.current

    fetchDataOperations.getReviewsList(context = context, mediaItem = sharedStates.selectedMediaItem)

    // Conditional That Determine If Media Item Is A Celebrity
    if (sharedStates.selectedMediaItem is Celebrity || sharedStates.selectedMediaItem
                is MovieCast || sharedStates.selectedMediaItem is TvSeriesCast
    ) { return } else {

    Column(
        modifier.padding(dimensions.detailsScreenCategoryPadding.dp)
    ) {

        // Category Header
        DetailsScreenCategoryHeader(icon = R.drawable.score_icon, text = "Reviews")

        // Conditional That Determines If The Review List Is Empty
        if (sharedStates.selectedMediaItem is Movie && states.movieReviewList.results.isEmpty() ||
            sharedStates.selectedMediaItem is TvSeries && states.tvSeriesReviewList.results.isEmpty() ||
            sharedStates.selectedMediaItem is CelebrityTvCast && states.tvSeriesReviewList.results.isEmpty() ||
         sharedStates.selectedMediaItem is CelebrityMovieCast && states.movieReviewList.results.isEmpty()){

            // Text That Appears If The Review List Is Empty
            Text(
                text = "No Reviews",
                modifier.padding(dimensions.reviewListItemPadding.dp),
                color = colors.detailsScreenFontAndIconColor,
                fontSize = dimensions.noReviewMessageFontSize.sp,
                fontWeight = FontWeight.SemiBold,)
        } else {

        // Review List
        LazyRow(
            modifier.padding(vertical =  dimensions.standardDetailsListItemPadding.dp),
            horizontalArrangement = Arrangement.spacedBy(dimensions.categoryListSpacing.dp)
        ) {

            items(userInterfaceOperations.determineMediaReviewList(
                movieReviewList = states.movieReviewList,
                tvSeriesReviewList = states.tvSeriesReviewList
            )) { review ->

                // Review List Item
                  ReviewListItem(mediaItem = review)
            }}
        }
    }}}
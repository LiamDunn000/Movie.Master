package com.movie_master.moviemaster.presentation.details_screen.details_screen_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import com.movie_master.moviemaster.data.details_screen_data.details_screen_states.detailsScreenStates
import com.movie_master.moviemaster.data.shared_data.sharedStates

@Composable
fun DetailsScreenSummary(
    modifier: Modifier = Modifier,
    dimensions: DetailsScreenDimensions = DetailsScreenDimensions(),
    colors: DetailsScreenColors = detailsScreenColors
) {

    // Details Screen Summary Layout
    Column(
        modifier.padding(dimensions.detailsScreenCategoryPadding.dp),
        verticalArrangement = Arrangement.spacedBy(dimensions.detailsScreenListSpacing.dp)
    ) {

        DetailsScreenCategoryHeader(icon = R.drawable.info_icon, text = "Summary")

        LazyColumn(
            modifier
                .heightIn(max = dimensions.detailsScreenSummaryHeight.dp)
                .fillMaxWidth(),
        ) {

            // Details Screen Summary
            item {
                Text(
                    text = when (sharedStates.selectedMediaItem) {
                        is Movie -> detailsScreenStates.movieDetails.overview
                        is TvSeries -> detailsScreenStates.tvSeriesDetails.overview
                        is Celebrity -> detailsScreenStates.celebrityDetails.biography
                        is MovieCast -> detailsScreenStates.celebrityDetails.biography
                        is TvSeriesCast -> detailsScreenStates.celebrityDetails.biography
                        is CelebrityMovieCast -> detailsScreenStates.movieDetails.overview
                        is CelebrityTvCast -> detailsScreenStates.tvSeriesDetails.overview
                        else -> ""
                    },
                    color = colors.detailsScreenFontAndIconColor,
                    fontSize = dimensions.detailsScreenCategoryDetailsFontSize.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = dimensions.detailsScreenCategoryLetterSpacing.sp
                )
            }
        }
    }
}
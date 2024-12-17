package com.movie_master.moviemaster.presentation.details_screen.details_screen_components

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import com.movie_master.moviemaster.R
import com.movie_master.moviemaster.data.api_data.movie._movie.Movie
import com.movie_master.moviemaster.data.api_data.movie.movie_release_date.MoviesReleaseDates
import com.movie_master.moviemaster.data.api_data.tv_series._tv_series.TvSeries
import com.movie_master.moviemaster.data.api_data.tv_series.tv_series_content_rating.TvContentRating
import com.movie_master.moviemaster.data.details_screen_data.details_screen_colors.detailsScreenColors
import com.movie_master.moviemaster.data.details_screen_data.details_screen_dimensions.DetailsScreenDimensions
import com.movie_master.moviemaster.data.shared_data.colors
import com.movie_master.moviemaster.data.shared_data.sharedStates
import com.movie_master.moviemaster.functionality.api_operations.RetrofitInstance
import com.movie_master.moviemaster.functionality.api_operations.fetchDataOperations
import com.movie_master.moviemaster.functionality.user_interface_operations.userInterfaceOperations
import kotlinx.coroutines.launch
import java.io.IOException

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun DetailsScreenHeaderInfoPanel(
    modifier: Modifier
) {

    var moviesReleaseDates by remember { mutableStateOf(MoviesReleaseDates()) }

    var tvSeriesContentRating by remember { mutableStateOf(TvContentRating()) }

    fun <T> getMediaItemReleaseDates(mediaItem: T) {
        fetchDataOperations.viewModelScope.launch {
            try {
                when (mediaItem) {
                    is Movie -> {
                        moviesReleaseDates = RetrofitInstance.api.getMovieReleaseDates(mediaItem.id).body()!!
                    }
                    is TvSeries -> {
                        tvSeriesContentRating = RetrofitInstance.api.getTvSeriesContentRatings(mediaItem.id).body()!!
                    }
                }
            }catch (e: Exception){
                return@launch
            }catch (e: HttpException){
                return@launch
            }catch (e: IOException){
                return@launch
            }
        }
    }

    getMediaItemReleaseDates(mediaItem = sharedStates.selectedMediaItem)

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)

    ) {

        // Review Score
        DetailsScreenHeaderInfoPanelItem(
            icon = userInterfaceOperations.determineMediaIcon(icon = R.drawable.score_icon),
            text = userInterfaceOperations.determineMediaReviewScore(mediaItem = sharedStates.selectedMediaItem),
            color = userInterfaceOperations.determineReviewScoreTextColor(
                mediaItem = sharedStates.selectedMediaItem,
            )
        )

        // Genre
        DetailsScreenHeaderInfoPanelItem(
            icon = userInterfaceOperations.determineMediaIcon(icon = R.drawable.genre_icon),
            text = userInterfaceOperations.determineMediaGenre()
        )

        // Age Rating
        DetailsScreenHeaderInfoPanelItem(
            icon = R.drawable.age_rating_icon,
            text = userInterfaceOperations.determineMediaAgeRating(
                mediaItem = sharedStates.selectedMediaItem,
                moviesReleaseDates = moviesReleaseDates,
                tvSeriesContentRating = tvSeriesContentRating
            )
        )

        // Release Date
        DetailsScreenHeaderInfoPanelItem(
            icon = R.drawable.calender_icon,
            text = userInterfaceOperations.determineMediaReleaseDate()
        )

        // Run Time
        DetailsScreenHeaderInfoPanelItem(
            icon = R.drawable.run_time_icon,
            text = userInterfaceOperations.determineMediaRunTime()
        )
    }

}

@Composable
fun DetailsScreenHeaderInfoPanelItem(
    modifier: Modifier = Modifier,
    dimensions: DetailsScreenDimensions = DetailsScreenDimensions(),
    icon: Int,
    text: String?,
    color: Color = detailsScreenColors.detailsScreenFontAndIconColor
) {

    Row(
        modifier
            .padding(start = dimensions.detailsScreenHeaderInfoPanelExternalPadding.dp)
            .width(dimensions.detailsScreenHeaderInfoPanelWidth.dp)
            .padding(horizontal = dimensions.detailsScreenHeaderInfoPanelInternalPadding.dp),
        horizontalArrangement = Arrangement.spacedBy(dimensions.detailsScreenHeaderInfoPanelSpacing.dp),
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(dimensions.detailsScreenHeaderIconSize.dp),
            colorFilter = ColorFilter.tint(colors.white)
        )

        Text(
            text = text ?: "",
            color = color,
            fontSize = dimensions.detailsScreenHeaderInfoPanelFontSize.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.basicMarquee()
            )
    }
}
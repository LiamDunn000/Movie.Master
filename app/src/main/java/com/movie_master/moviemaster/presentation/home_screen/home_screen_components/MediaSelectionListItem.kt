package com.movie_master.moviemaster.presentation.home_screen.home_screen_components

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.movie_master.moviemaster.data.add_to_list_dialog_data.add_to_list_dialog_states.AddToListDialogStates
import com.movie_master.moviemaster.data.api_data.movie._movie.Movie
import com.movie_master.moviemaster.data.api_data.movie.movie_release_date.MoviesReleaseDates
import com.movie_master.moviemaster.data.api_data.tv_series._tv_series.TvSeries
import com.movie_master.moviemaster.data.api_data.tv_series.tv_series_content_rating.TvContentRating
import com.movie_master.moviemaster.data.home_screen_data.home_screen_colors.HomeScreenColors
import com.movie_master.moviemaster.data.home_screen_data.home_screen_colors.homeScreenColors
import com.movie_master.moviemaster.data.home_screen_data.home_screen_data_dimensions.HomeScreenDimensions
import com.movie_master.moviemaster.data.shared_data.sharedStates
import com.movie_master.moviemaster.functionality.api_operations.RetrofitInstance
import com.movie_master.moviemaster.functionality.api_operations.fetchDataOperations
import com.movie_master.moviemaster.functionality.api_operations.manageProfileOperations
import com.movie_master.moviemaster.functionality.navigation_operations.navigationOperations
import com.movie_master.moviemaster.functionality.user_interface_operations.UserInterfaceOperations
import com.movie_master.moviemaster.functionality.user_interface_operations.userInterfaceOperations
import kotlinx.coroutines.launch
import java.io.IOException

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun MediaSelectionListItem(
    modifier: Modifier = Modifier,
    dimensions: HomeScreenDimensions = HomeScreenDimensions(),
    colors: HomeScreenColors = homeScreenColors,
    operations: UserInterfaceOperations = userInterfaceOperations,
    navController: NavController,
    mediaItem: Any,
) {

    val context = LocalContext.current

    var moviesReleaseDates by remember {mutableStateOf(MoviesReleaseDates())}

    var tvSeriesContentRating by remember { mutableStateOf(TvContentRating()) }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun <T> getMediaItemDetails(mediaItem: T) {
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

    // Get Media Item Details
    getMediaItemDetails(mediaItem)

    // Movie Selection List Item Frame
    Card(
        shape = RoundedCornerShape(dimensions.movieSelectionListItemCornerRadius),
        elevation = CardDefaults.cardElevation(dimensions.movieSelectionListItemElevation.dp),
        colors = CardDefaults.cardColors(colors.mediaSelectionListItemBackgroundColor),
    ) {

        // Movie Selection List Item Layout
        Column(
            modifier
                .pointerInput(mediaItem) {
                    detectTapGestures (
                        onTap = {
                            navigationOperations.navigateToDetailsScreen(
                                context = context,
                                navController = navController,
                                mediaItem = mediaItem
                            )
                        },
                        onLongPress = { manageProfileOperations.selectMediaToAddToList(mediaItem = mediaItem) },
                        onDoubleTap = {}
                    )

                }
                .background(color = colors.mediaSelectionListItemBackgroundColor)
                .width(dimensions.movieSelectionListItemWidth.dp)
                .fillMaxSize()
        ) {

            // Movie Selection List Item Image
            AsyncImage(
                model = operations.determineMediaImageUrl(mediaItem = mediaItem),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.height(dimensions.movieSelectionListItemImageHeight.dp)
            )

            // Movie Selection List Item Info Section
            Column(
                modifier
                    .fillMaxSize()
                    .padding(dimensions.movieSelectionListItemPadding.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                // Movie Selection List Item Title
                Text(
                    text = operations.determineMediaTitle(mediaItem = mediaItem),
                    color = colors.mediaSelectionListItemTitleTextColor,
                    fontSize = dimensions.movieSelectionListItemTitleFontSize.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.basicMarquee()
                    )

                Row(
                    modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    // Movie Selection List Item Age Rating
                        Text(
                            text = operations.determineMediaAgeRating(
                                mediaItem = mediaItem,
                                moviesReleaseDates = moviesReleaseDates,
                                tvSeriesContentRating = tvSeriesContentRating),
                            color = colors.mediaSelectionListItemAgeRatingTextColor,
                            fontSize = dimensions.movieSelectionListItemDetailsFontSize.sp,)

                                // Movie Selection List Item Review Score
                                Text(
                                    text = operations.determineMediaReviewScore(mediaItem = mediaItem),
                                    color = operations.determineReviewScoreTextColor(mediaItem = mediaItem),
                                    fontSize = dimensions.movieSelectionListItemDetailsFontSize.sp,)
                        }

                }
            }
        }
}

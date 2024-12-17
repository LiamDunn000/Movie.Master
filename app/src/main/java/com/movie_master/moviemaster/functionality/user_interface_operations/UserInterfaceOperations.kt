package com.movie_master.moviemaster.functionality.user_interface_operations

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.movie_master.moviemaster.R
import com.movie_master.moviemaster.data.api_data.celebrity._celebrity.Celebrity
import com.movie_master.moviemaster.data.api_data.celebrity.celebrity_images.CelebrityImages
import com.movie_master.moviemaster.data.api_data.celebrity.celebrity_images.CelebrityProfile
import com.movie_master.moviemaster.data.api_data.celebrity.celebrity_movie_credits.CelebrityMovieCast
import com.movie_master.moviemaster.data.api_data.celebrity.celebrity_movie_credits.CelebrityMovieCredits
import com.movie_master.moviemaster.data.api_data.celebrity.celebrity_tv_credits.CelebrityTvCast
import com.movie_master.moviemaster.data.api_data.celebrity.celebrity_tv_credits.CelebrityTvCredits
import com.movie_master.moviemaster.data.api_data.movie._movie.Movie
import com.movie_master.moviemaster.data.api_data.movie.movie_credits.MovieCast
import com.movie_master.moviemaster.data.api_data.movie.movie_credits.MovieCredits
import com.movie_master.moviemaster.data.api_data.movie.movie_images.MovieBackdrop
import com.movie_master.moviemaster.data.api_data.movie.movie_images.MovieImages
import com.movie_master.moviemaster.data.api_data.movie.movie_release_date.MoviesReleaseDates
import com.movie_master.moviemaster.data.api_data.movie.movie_reviews.MovieReview
import com.movie_master.moviemaster.data.api_data.movie.movie_reviews.MovieReviews
import com.movie_master.moviemaster.data.api_data.tv_series._tv_series.TvSeries
import com.movie_master.moviemaster.data.api_data.tv_series.tv_credits.TvSeriesCast
import com.movie_master.moviemaster.data.api_data.tv_series.tv_credits.TvSeriesCredits
import com.movie_master.moviemaster.data.api_data.tv_series.tv_series_content_rating.TvContentRating
import com.movie_master.moviemaster.data.api_data.tv_series.tv_series_images.TvSeriesBackdrop
import com.movie_master.moviemaster.data.api_data.tv_series.tv_series_images.TvSeriesImages
import com.movie_master.moviemaster.data.api_data.tv_series.tv_series_reviews.TvSeriesReview
import com.movie_master.moviemaster.data.api_data.tv_series.tv_series_reviews.TvSeriesReviews
import com.movie_master.moviemaster.data.details_screen_data.details_screen_states.detailsScreenStates
import com.movie_master.moviemaster.data.home_screen_data.home_screen_colors.HomeScreenColors
import com.movie_master.moviemaster.data.home_screen_data.home_screen_colors.homeScreenColors
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_states.mediaSearchBarStates
import com.movie_master.moviemaster.data.shared_data.sharedStates
import com.movie_master.moviemaster.data.screen_nav_bar_data.screen_nav_bar_colors.screenNavBarColors
import com.movie_master.moviemaster.data.screen_nav_bar_data.screen_nav_bar_states.screenNavBarStates
import com.movie_master.moviemaster.functionality.api_operations.fetchDataOperations

val userInterfaceOperations = UserInterfaceOperations()

class UserInterfaceOperations: ViewModel() {


    // COLORS --------------------------------------------------------------------------------------
    fun <T> determineReviewScoreTextColor(mediaItem: T, colors: HomeScreenColors = homeScreenColors): Color {
        return when (mediaItem) {
            is Movie -> {when {
                mediaItem.vote_average >= 7 -> colors.positiveMediaSelectionListItemReviewScoreTextColor
                mediaItem.vote_average >= 5 -> colors.averageMediaSelectionListItemReviewScoreTextColor
                else -> colors.negativeMediaSelectionListItemReviewScoreTextColor
            }}
            is TvSeries -> {when {
                mediaItem.vote_average >= 7 -> colors.positiveMediaSelectionListItemReviewScoreTextColor
                mediaItem.vote_average >= 5 -> colors.averageMediaSelectionListItemReviewScoreTextColor
                else -> colors.negativeMediaSelectionListItemReviewScoreTextColor
            }}
            else -> {Color.White}
        }
    }

    fun determinedCategorySelectionButtonColors(
        text: String,
        selectedColor: Color,
        unselectedColor: Color
    ): Color {
        return if (mediaSearchBarStates.selectedCategory == text)
            selectedColor else unselectedColor
    }

    fun determineScreenNavBarButtonColors(text: String): Color {
        return if (screenNavBarStates.selectedScreen == text)
            screenNavBarColors.selectedScreenNavBarButtonColor
        else screenNavBarColors.unselectedScreenNavBarButtonColor
    }
    // ---------------------------------------------------------------------------------------------

    // MEDIA MAIN INFO -----------------------------------------------------------------------------

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun <T> determineMediaDetails(context: Context, mediaItem: T) {
        return when (mediaItem) {
            is Movie -> {
                sharedStates.selectedMediaItem = mediaItem
                fetchDataOperations.getMovieDetails(
                    context = context, movieId = mediaItem.id)
                fetchDataOperations.getSimilarMovies(
                    context = context, movieId = mediaItem.id)
            }
            is TvSeries -> {
                sharedStates.selectedMediaItem = mediaItem
                fetchDataOperations.getTvSeriesDetails(
                    context = context, seriesId = mediaItem.id)
                fetchDataOperations.getSimilarTvSeries(
                    context = context, seriesId = mediaItem.id)
            }
            is Celebrity -> {
                sharedStates.selectedMediaItem = mediaItem
                fetchDataOperations.getCelebrityDetails(
                    context = context, personId = mediaItem.id)
            }
            is MovieCast -> {
                sharedStates.selectedMediaItem = mediaItem
                fetchDataOperations.getCelebrityDetails(
                    context = context, personId = mediaItem.id)
            }
            is TvSeriesCast -> {
                sharedStates.selectedMediaItem = mediaItem
                fetchDataOperations.getCelebrityDetails(
                    context = context, personId = mediaItem.id)
            }
            is CelebrityMovieCast -> {
                sharedStates.selectedMediaItem = mediaItem
                fetchDataOperations.getMovieDetails(
                    context = context, movieId = mediaItem.id)
                fetchDataOperations.getSimilarMovies(
                    context = context, movieId = mediaItem.id)
            }
            is CelebrityTvCast -> {
                sharedStates.selectedMediaItem = mediaItem
                fetchDataOperations.getTvSeriesDetails(
                    context = context, seriesId = mediaItem.id)
                fetchDataOperations.getSimilarTvSeries(
                    context = context, seriesId = mediaItem.id)
            }

            else -> {return}
        }
    }

    fun <T> determineMediaTitle(mediaItem: T): String {
        return when (mediaItem) {
            is Movie -> mediaItem.title
            is TvSeries -> mediaItem.name
            is Celebrity -> mediaItem.name
            is MovieCast -> mediaItem.name
            is TvSeriesCast -> mediaItem.name
            is CelebrityMovieCast -> mediaItem.title
            is CelebrityTvCast -> mediaItem.name
            else -> {""}
        }
    }

    // MEDIA IMAGE URL -----------------------------------------------------------------------------
    fun <T> determineMediaImageUrl(
        mediaItem: T, format: String = ""): String {
        return "${sharedStates.mediaImageBaseUrl}${
            when (mediaItem) {
                is Movie -> mediaItem.poster_path
                is TvSeries -> mediaItem.poster_path
                is Celebrity -> mediaItem.profile_path
                is MovieCast -> mediaItem.profile_path
                is TvSeriesCast -> mediaItem.profile_path
                is CelebrityMovieCast -> mediaItem.poster_path
                is CelebrityTvCast -> mediaItem.poster_path
                else -> {""}
            }}$format"
    }

    fun determineMediaBackgroundImageUrl(): String {
        return "${sharedStates.mediaImageBaseUrl}${
            when (sharedStates.selectedMediaItem) {
                is Movie -> detailsScreenStates.movieDetails.poster_path
                is TvSeries -> detailsScreenStates.tvSeriesDetails.poster_path
                is CelebrityMovieCast -> detailsScreenStates.movieDetails.poster_path
                is CelebrityTvCast -> detailsScreenStates.tvSeriesDetails.poster_path
                else -> {""}
            }}.svg"
    }
    // ---------------------------------------------------------------------------------------------

    // MEDIA DETAILS -------------------------------------------------------------------------------
    fun determineMediaIcon(icon: Int): Int {
        return when (sharedStates.selectedMediaItem) {
            is Movie -> icon
            is TvSeries -> icon
            is CelebrityMovieCast -> icon
            is CelebrityTvCredits -> icon
            else -> R.drawable.null_icon
        }
    }

    fun <T> determineMediaReviewScore(mediaItem: T): String {
        return when (mediaItem) {
            is Movie -> mediaItem.vote_average.toString().substring(0, 3)
            is TvSeries -> mediaItem.vote_average.toString().substring(0, 3)
            is CelebrityMovieCast -> detailsScreenStates.movieDetails.vote_average.toString().substring(0, 3)
            is CelebrityTvCast -> detailsScreenStates.tvSeriesDetails.vote_average.toString().substring(0, 3)
            else -> {""}
        }
    }

    fun determineMediaGenre(): String {
        return when (sharedStates.selectedMediaItem) {
            is Movie -> detailsScreenStates.movieDetails.genres.find { true }?.name?:"N/A"
            is TvSeries -> detailsScreenStates.tvSeriesDetails.genres.find { true }?.name?:"N/A"
            is CelebrityMovieCast -> detailsScreenStates.movieDetails.genres.find { true }?.name?:"N/A"
            is CelebrityTvCast -> detailsScreenStates.tvSeriesDetails.genres.find { true }?.name?:"N/A"
            else -> ""
        }
    }

    fun <T> determineMediaAgeRating(
        mediaItem: T,
        moviesReleaseDates: MoviesReleaseDates,
        tvSeriesContentRating: TvContentRating,
        ): String {
        return when (mediaItem) {
            is Movie -> {moviesReleaseDates.results.find { it.iso_3166_1 == "US" }?.release_dates
                ?.firstOrNull { it.certification != "" }?.certification ?: "N/A"}
            is TvSeries -> {tvSeriesContentRating.results.find { it.iso_3166_1 == "US" }?.rating?: "N/A"}
            is Celebrity ->  {mediaItem.known_for_department?:"N/A"}
            is MovieCast -> detailsScreenStates.celebrityDetails.known_for_department?:"N/A"
            is TvSeriesCast -> detailsScreenStates.celebrityDetails.known_for_department?:"N/A"
            is CelebrityMovieCast -> {moviesReleaseDates.results.find { it.iso_3166_1 == "US" }?.release_dates
                ?.firstOrNull { it.certification != "" }?.certification ?: "N/A"}
            is CelebrityTvCast -> {tvSeriesContentRating.results.find { it.iso_3166_1 == "US" }?.rating?: "N/A"}
            else -> {""}
        }
    }

    fun determineMediaReleaseDate(): String {
        return when (sharedStates.selectedMediaItem) {
            is Movie -> detailsScreenStates.movieDetails.release_date
            is TvSeries -> detailsScreenStates.tvSeriesDetails.first_air_date
            is MovieCast -> detailsScreenStates.celebrityDetails.birthday
            is TvSeriesCast -> detailsScreenStates.celebrityDetails.birthday
            is CelebrityMovieCast -> detailsScreenStates.movieDetails.release_date
            is CelebrityTvCast -> detailsScreenStates.tvSeriesDetails.first_air_date
            else -> ""
        }
    }

    fun determineMediaRunTime(): String {
        return when (sharedStates.selectedMediaItem) {
            is Movie -> "${detailsScreenStates.movieDetails.runtime} min"
            is TvSeries -> detailsScreenStates.tvSeriesDetails.last_air_date
            is Celebrity -> detailsScreenStates.celebrityDetails.deathday?:"Present"
            is MovieCast -> detailsScreenStates.celebrityDetails.deathday?:"Present"
            is TvSeriesCast -> detailsScreenStates.celebrityDetails.deathday?:"Present"
            is CelebrityMovieCast -> "${detailsScreenStates.movieDetails.runtime} min"
            is CelebrityTvCast -> detailsScreenStates.tvSeriesDetails.last_air_date
            else -> ""
        }
    }

    fun determineMediaCreditsList(
        movieCreditsList: MovieCredits,
        tvSeriesCreditsList: TvSeriesCredits,
        celebrityMovieCredits: CelebrityMovieCredits
    ): List<Any> {
        return when (sharedStates.selectedMediaItem) {
            is Movie -> movieCreditsList.cast
            is TvSeries -> tvSeriesCreditsList.cast
            is Celebrity -> celebrityMovieCredits.cast
            is MovieCast -> celebrityMovieCredits.cast
            is TvSeriesCast -> celebrityMovieCredits.cast
            is CelebrityMovieCast -> movieCreditsList.cast
            is CelebrityTvCast -> tvSeriesCreditsList.cast
            else -> listOf()
        }
    }

    fun determineMediaBackdropImageList(
        movieImageList: MovieImages,
        tvSeriesImageList: TvSeriesImages,
        celebrityImageList: CelebrityImages
    ): List<Any> {
        return when (sharedStates.selectedMediaItem) {
            is Movie -> movieImageList.backdrops
            is TvSeries -> tvSeriesImageList.backdrops
            is Celebrity -> celebrityImageList.profiles
            is MovieCast -> celebrityImageList.profiles
            is TvSeriesCast -> celebrityImageList.profiles
            is CelebrityMovieCast -> movieImageList.backdrops
            is CelebrityTvCast -> tvSeriesImageList.backdrops
            else -> listOf()
        }
    }

    fun <T> determineMediaBackdropImageUrl(mediaItem: T): String {
        return "${sharedStates.mediaImageBaseUrl}${
            when (mediaItem) {
                is MovieBackdrop -> mediaItem.file_path
                is TvSeriesBackdrop -> mediaItem.file_path
                is CelebrityProfile -> mediaItem.file_path
                else -> {""}
            }}.svg"
    }

    fun determineSimilarMedia(): List<Any> {
        return when (sharedStates.selectedMediaItem) {
            is Movie -> detailsScreenStates.similarMovies.results
            is TvSeries -> detailsScreenStates.similarTvSeries.results
            else -> listOf()
        }
    }
    // ---------------------------------------------------------------------------------------------

    // REVIEWS -------------------------------------------------------------------------------------
    fun determineMediaReviewList(
        movieReviewList: MovieReviews,
        tvSeriesReviewList: TvSeriesReviews
    ): List<Any> {
        return when (sharedStates.selectedMediaItem) {
            is Movie -> movieReviewList.results
            is TvSeries -> tvSeriesReviewList.results
            is CelebrityTvCast -> tvSeriesReviewList.results
            is CelebrityMovieCast -> movieReviewList.results
            else -> listOf()
        }
    }

    fun determineMediaReviewContent(mediaItem: Any): String {
        return when (mediaItem) {
            is MovieReview -> mediaItem.content
            is TvSeriesReview -> mediaItem.content
            else -> ""
        }
    }

    fun determineMediaReviewAuthor(mediaItem: Any): String {
        return when (mediaItem) {
            is MovieReview -> mediaItem.author
            is TvSeriesReview -> mediaItem.author
            else -> ""
        }
    }

    fun determineMediaReviewPostedDate(mediaItem: Any): String {
        return when (mediaItem) {
            is MovieReview -> mediaItem.created_at.substring(0, 10)
            is TvSeriesReview -> mediaItem.created_at.substring(0, 10)
            else -> ""
        }
    }
    // ---------------------------------------------------------------------------------------------
}
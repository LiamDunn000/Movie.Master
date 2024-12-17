package com.movie_master.moviemaster.data.details_screen_data.details_screen_states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.movie_master.moviemaster.data.api_data.celebrity.celebrity_details.CelebrityDetails
import com.movie_master.moviemaster.data.api_data.celebrity.celebrity_images.CelebrityImages
import com.movie_master.moviemaster.data.api_data.celebrity.celebrity_movie_credits.CelebrityMovieCredits
import com.movie_master.moviemaster.data.api_data.celebrity.celebrity_tv_credits.CelebrityTvCredits
import com.movie_master.moviemaster.data.api_data.movie._movie.MovieList
import com.movie_master.moviemaster.data.api_data.movie.movie_credits.MovieCredits
import com.movie_master.moviemaster.data.api_data.movie.movie_details.MovieDetails
import com.movie_master.moviemaster.data.api_data.movie.movie_images.MovieImages
import com.movie_master.moviemaster.data.api_data.movie.movie_reviews.MovieReviews
import com.movie_master.moviemaster.data.api_data.tv_series._tv_series.TvSeriesList
import com.movie_master.moviemaster.data.api_data.tv_series.tv_credits.TvSeriesCredits
import com.movie_master.moviemaster.data.api_data.tv_series.tv_series_details.TvSeriesDetails
import com.movie_master.moviemaster.data.api_data.tv_series.tv_series_images.TvSeriesImages
import com.movie_master.moviemaster.data.api_data.tv_series.tv_series_reviews.TvSeriesReviews

val detailsScreenStates = DetailsScreenStates()

class DetailsScreenStates: ViewModel() {

    var detailsScreenDestination = "Details Screen"

    // Media Details
    var movieDetails by mutableStateOf(MovieDetails())
    var tvSeriesDetails by mutableStateOf(TvSeriesDetails())
    var celebrityDetails by mutableStateOf(CelebrityDetails())

    // Media Credits
    var movieCreditsList by mutableStateOf(MovieCredits())
    var tvSeriesCreditsList by mutableStateOf(TvSeriesCredits())
    var celebrityMovieCreditsList by mutableStateOf(CelebrityMovieCredits())
    var celebrityTvSeriesCreditsList by mutableStateOf(CelebrityTvCredits())

    // Media Images
    var movieImageList by mutableStateOf(MovieImages())
    var tvSeriesImageList by mutableStateOf(TvSeriesImages())
    var celebrityImageList by mutableStateOf(CelebrityImages())

    // Media Reviews
    var movieReviewList by mutableStateOf(MovieReviews())
    var tvSeriesReviewList by mutableStateOf(TvSeriesReviews())

    // Similar Media
    var similarMovies by mutableStateOf(MovieList())
    var similarTvSeries by mutableStateOf(TvSeriesList())

    // Image Enlargement
    var selectedImage by mutableStateOf(Any())
    var isImageEnlarged by mutableStateOf(false)

    // Review Enlargement
    var selectedReview by mutableStateOf(Any())
    var isReviewEnlarged by mutableStateOf(false)
}
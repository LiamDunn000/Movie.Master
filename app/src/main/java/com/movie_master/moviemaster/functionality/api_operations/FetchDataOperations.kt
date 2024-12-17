package com.movie_master.moviemaster.functionality.api_operations

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie_master.moviemaster.data.api_data.celebrity._celebrity.Celebrity
import com.movie_master.moviemaster.data.api_data.celebrity.celebrity_movie_credits.CelebrityMovieCast
import com.movie_master.moviemaster.data.api_data.celebrity.celebrity_tv_credits.CelebrityTvCast
import com.movie_master.moviemaster.data.api_data.movie._movie.Movie
import com.movie_master.moviemaster.data.api_data.movie.movie_credits.MovieCast
import com.movie_master.moviemaster.data.api_data.tv_series._tv_series.TvSeries
import com.movie_master.moviemaster.data.api_data.tv_series.tv_credits.TvSeriesCast
import com.movie_master.moviemaster.data.details_screen_data.details_screen_states.detailsScreenStates
import com.movie_master.moviemaster.data.home_screen_data.home_screen_states.HomeScreenStates
import com.movie_master.moviemaster.functionality.general_operations.generalOperations
import kotlinx.coroutines.launch

val fetchDataOperations = FetchDataOperations()

class FetchDataOperations: ViewModel() {

    fun getHomeScreenData(context: Context) {
        viewModelScope.launch {
            try {
                HomeScreenStates.moviesNowPlayIngList = RetrofitInstance.api.getMoviesNowPlaying().body()!!
                HomeScreenStates.topRatedMovieList = RetrofitInstance.api.getPopularMovies().body()!!
                HomeScreenStates.trendingMovieList = RetrofitInstance.api.getTrendingMovies(timeWindow = "week").body()!!
                HomeScreenStates.tvSeriesOnAirList = RetrofitInstance.api.getTvSeriesOnAir().body()!!
                HomeScreenStates.topRatedTvSeriesList = RetrofitInstance.api.geTopRatedTvSeries().body()!!
                HomeScreenStates.trendingTvSeriesList = RetrofitInstance.api.getTrendingTvSeries(timeWindow = "week").body()!!
                HomeScreenStates.trendingCelebritiesList = RetrofitInstance.api.getTrendingCelebrities(timeWindow = "week").body()!!
            }catch (e: Exception){
                generalOperations.showErrorLoadingDataMessage(context = context, data = "Data")
                return@launch
            }
        }
    }

    fun getMovieDetails(context: Context, movieId: Int) {
        viewModelScope.launch {
            try {
                detailsScreenStates.movieDetails = RetrofitInstance.api.getMovieDetails(movieId = movieId).body()!!
            }catch (e: Exception){
                generalOperations.showErrorLoadingDataMessage(context = context, data = "Data")
                return@launch
            }
        }
    }

    fun getTvSeriesDetails(context: Context, seriesId: Int) {
        viewModelScope.launch {
            try {
                detailsScreenStates.tvSeriesDetails = RetrofitInstance.api.getTvSeriesDetails(seriesId = seriesId).body()!!
            }catch (e: Exception){
                generalOperations.showErrorLoadingDataMessage(context = context, data = "Data")
                return@launch
            }
        }
    }

    fun getCelebrityDetails(context: Context, personId: Int) {
        viewModelScope.launch {
            try {
                detailsScreenStates.celebrityDetails = RetrofitInstance.api.getCelebrityDetails(personId = personId).body()!!
            }catch (e: Exception){
                generalOperations.showErrorLoadingDataMessage(context = context, data = "Data")
                return@launch
            }
        }
    }

    fun getSimilarMovies(context: Context, movieId: Int) {
        viewModelScope.launch {
            try {
                detailsScreenStates.similarMovies = RetrofitInstance.api.getSimilarMovies(movieId = movieId).body()!!
            }catch (e: Exception){
                generalOperations.showErrorLoadingDataMessage(context = context, data = "Similar Movies")
                return@launch
            }
        }
    }

    fun getSimilarTvSeries(context: Context, seriesId: Int) {
        viewModelScope.launch {
            try {
                detailsScreenStates.similarTvSeries = RetrofitInstance.api.getSimilarTvSeries(seriesId = seriesId).body()!!
            }catch (e: Exception){
                generalOperations.showErrorLoadingDataMessage(context = context, data = "Similar Tv Series")
                return@launch
            }
        }
    }

    fun getCreditsDetails(context: Context, mediaItem: Any) {
        viewModelScope.launch {
            try {
                when(mediaItem) {
                    is Movie -> detailsScreenStates.movieCreditsList = RetrofitInstance.api.getMovieCredits(movieId = mediaItem.id).body()!!
                    is TvSeries -> detailsScreenStates.tvSeriesCreditsList = RetrofitInstance.api.getTvSeriesCredits(seriesId = mediaItem.id).body()!!
                    is Celebrity -> {
                        detailsScreenStates.celebrityMovieCreditsList = RetrofitInstance.api.getCelebrityMovieCredits(personId = mediaItem.id).body()!!
                        detailsScreenStates.celebrityTvSeriesCreditsList = RetrofitInstance.api.getCelebrityTvCredits(personId = mediaItem.id).body()!!
                    }
                    is MovieCast -> {
                        detailsScreenStates.celebrityMovieCreditsList = RetrofitInstance.api.getCelebrityMovieCredits(personId = mediaItem.id).body()!!
                        detailsScreenStates.celebrityTvSeriesCreditsList = RetrofitInstance.api.getCelebrityTvCredits(personId = mediaItem.id).body()!!
                    }
                    is TvSeriesCast -> {
                        detailsScreenStates.celebrityMovieCreditsList = RetrofitInstance.api.getCelebrityMovieCredits(personId = mediaItem.id).body()!!
                        detailsScreenStates.celebrityTvSeriesCreditsList = RetrofitInstance.api.getCelebrityTvCredits(personId = mediaItem.id).body()!!
                    }
                    is CelebrityMovieCast -> detailsScreenStates.movieCreditsList = RetrofitInstance.api.getMovieCredits(movieId = mediaItem.id).body()!!
                    is CelebrityTvCast -> detailsScreenStates.tvSeriesCreditsList = RetrofitInstance.api.getTvSeriesCredits(seriesId = mediaItem.id).body()!!
                    else -> (return@launch)
                }
            }catch (e: Exception){
                generalOperations.showErrorLoadingDataMessage(context = context, data = "Credits")
                return@launch
            }
        }
    }

    fun getImagesList(context: Context, mediaItem: Any) {
        viewModelScope.launch {
            try {
                when(mediaItem) {
                    is Movie -> detailsScreenStates.movieImageList = RetrofitInstance.api.getMovieImages(movieId = mediaItem.id).body()!!
                    is TvSeries -> detailsScreenStates.tvSeriesImageList = RetrofitInstance.api.getTvSeriesImages(seriesId = mediaItem.id).body()!!
                    is Celebrity -> detailsScreenStates.celebrityImageList = RetrofitInstance.api.getCelebrityImages(personId = mediaItem.id).body()!!
                    is MovieCast -> detailsScreenStates.celebrityImageList = RetrofitInstance.api.getCelebrityImages(personId = mediaItem.id).body()!!
                    is TvSeriesCast -> detailsScreenStates.celebrityImageList = RetrofitInstance.api.getCelebrityImages(personId = mediaItem.id).body()!!
                    is CelebrityMovieCast -> detailsScreenStates.movieImageList = RetrofitInstance.api.getMovieImages(movieId = mediaItem.id).body()!!
                    is CelebrityTvCast -> detailsScreenStates.tvSeriesImageList = RetrofitInstance.api.getTvSeriesImages(seriesId = mediaItem.id).body()!!
                    else -> (return@launch)
                }
            }catch (e: Exception){
                generalOperations.showErrorLoadingDataMessage(context = context, data = "Images")
                return@launch
            }
        }
    }

    fun getReviewsList(context: Context, mediaItem: Any) {
        viewModelScope.launch {
            try {
                when(mediaItem) {
                    is Movie -> detailsScreenStates.movieReviewList = RetrofitInstance.api.getMovieReviews(movieId = mediaItem.id).body()!!
                    is TvSeries -> detailsScreenStates.tvSeriesReviewList = RetrofitInstance.api.getTvSeriesReviews(seriesId = mediaItem.id).body()!!
                    is CelebrityMovieCast -> detailsScreenStates.movieReviewList = RetrofitInstance.api.getMovieReviews(movieId = mediaItem.id).body()!!
                    is CelebrityTvCast -> detailsScreenStates.tvSeriesReviewList = RetrofitInstance.api.getTvSeriesReviews(seriesId = mediaItem.id).body()!!
                    else -> (return@launch)
                }
            }catch (e: Exception){
                generalOperations.showErrorLoadingDataMessage(context = context, "Reviews")
                return@launch
            }
        }
    }
}
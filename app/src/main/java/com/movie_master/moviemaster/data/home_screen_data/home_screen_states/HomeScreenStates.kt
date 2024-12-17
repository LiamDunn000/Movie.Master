package com.movie_master.moviemaster.data.home_screen_data.home_screen_states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.movie_master.moviemaster.data.api_data.celebrity._celebrity.CelebrityList
import com.movie_master.moviemaster.data.api_data.movie._movie.MovieList
import com.movie_master.moviemaster.data.api_data.tv_series._tv_series.TvSeriesList

//val homeScreenStates = HomeScreenStates()

class HomeScreenStates: ViewModel() {

    companion object {
    var homeScreenDestination = "Home Screen"

    // MOVIE LISTS ---------------------------------------------------------------------------------
    var moviesNowPlayIngList by mutableStateOf(MovieList())

    var topRatedMovieList by mutableStateOf(MovieList())

    var trendingMovieList by mutableStateOf(MovieList())
    // ---------------------------------------------------------------------------------------------

    // TV SERIES LISTS -----------------------------------------------------------------------------
    var tvSeriesOnAirList by mutableStateOf(TvSeriesList())

    var topRatedTvSeriesList by mutableStateOf(TvSeriesList())

    var trendingTvSeriesList by mutableStateOf(TvSeriesList())
    // ---------------------------------------------------------------------------------------------

    // CELEBRITY LISTS -----------------------------------------------------------------------------
    var trendingCelebritiesList by mutableStateOf(CelebrityList())
    // ---------------------------------------------------------------------------------------------
}}
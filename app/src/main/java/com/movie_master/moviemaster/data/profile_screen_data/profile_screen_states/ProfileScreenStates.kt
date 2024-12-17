package com.movie_master.moviemaster.data.profile_screen_data.profile_screen_states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.movie_master.moviemaster.data.api_data.list_item_status_data.ListItemStatusResponse
import com.movie_master.moviemaster.data.api_data.movie._movie.MovieList
import com.movie_master.moviemaster.data.api_data.profile.session.RequestToken
import com.movie_master.moviemaster.data.api_data.profile.session.SessionDeletion
import com.movie_master.moviemaster.data.api_data.profile.user_details.UserDetails
import com.movie_master.moviemaster.data.api_data.tv_series._tv_series.TvSeriesList
import com.movie_master.moviemaster.data.api_data.profile.session.SessionId

val profileScreenStates = ProfileScreenStates()

class ProfileScreenStates: ViewModel() {

    val profileScreenDestination = "Profile Screen"

    // Login
    var isLoginAttempted by mutableStateOf(false)
    var isPermissionGranted by mutableStateOf(false)
    var isUserLoggedOut by mutableStateOf(true)

    // Session
    var requestToken by mutableStateOf(RequestToken())
    var sessionId by mutableStateOf(SessionId())
    var sessionDeletion by mutableStateOf(SessionDeletion())

    fun loginPageUrl(requestToken: String): String {
    return "https://www.themoviedb.org/authenticate/${requestToken}"}

    var userDetails by mutableStateOf(UserDetails())

    // Favorite Lists
    var favoriteMoviesList by mutableStateOf(MovieList())
    var favoriteTvSeriesList by mutableStateOf(TvSeriesList())

    // Watch Lists
    var moviesOnWatchList by mutableStateOf(MovieList())
    var tvSeriesOnWatchList by mutableStateOf(TvSeriesList())

    var addToWatchListResponse by mutableStateOf(ListItemStatusResponse())
    var addToFavoriteListResponse by mutableStateOf(ListItemStatusResponse())

}

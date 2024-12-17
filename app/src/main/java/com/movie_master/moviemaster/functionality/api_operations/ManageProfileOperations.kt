package com.movie_master.moviemaster.functionality.api_operations

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie_master.moviemaster.data.add_to_list_dialog_data.add_to_list_dialog_states.AddToListDialogStates
import com.movie_master.moviemaster.data.api_data.celebrity.celebrity_movie_credits.CelebrityMovieCast
import com.movie_master.moviemaster.data.api_data.celebrity.celebrity_tv_credits.CelebrityTvCast
import com.movie_master.moviemaster.data.api_data.movie._movie.Movie
import com.movie_master.moviemaster.data.api_data.tv_series._tv_series.TvSeries
import com.movie_master.moviemaster.data.profile_screen_data.profile_screen_states.profileScreenStates
import com.movie_master.moviemaster.data.shared_data.RequestBody
import com.movie_master.moviemaster.data.shared_data.sharedStates
import com.movie_master.moviemaster.functionality.general_operations.generalOperations
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val manageProfileOperations = ManageProfileOperations()

class ManageProfileOperations: ViewModel() {

    // LOGIN OPERATIONS ----------------------------------------------------------------------------
    fun manageLoginButtonOnClickStates(context: Context) {
        if (profileScreenStates.isUserLoggedOut) {
            getRequestToken(context = context)
        } else { deleteSession(context = context, requestBody = RequestBody().deleteSessionRequestBody) }
    }

    fun goToLoginPage(context: Context) {
        if (profileScreenStates.requestToken.request_token.isNotEmpty() && profileScreenStates.isLoginAttempted) {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(profileScreenStates.loginPageUrl(requestToken = profileScreenStates.requestToken.request_token)))
            )
            profileScreenStates.isLoginAttempted = false
            profileScreenStates.isPermissionGranted = true
            viewModelScope.launch {
                delay(400)
                profileScreenStates.isUserLoggedOut = false
            }
    }}

    private fun getRequestToken(context: Context) {
        viewModelScope.launch {
           try {
               profileScreenStates.requestToken = RetrofitInstance.api.getRequestToken().body()!!
               profileScreenStates.isLoginAttempted = true
            }catch (e: Exception){
                generalOperations.showErrorAccessingAccountMessage(context = context)
                return@launch
            }
        }
    }

    fun createSession(context: Context, requestToken: okhttp3.RequestBody) {
        viewModelScope.launch {
            try {
                profileScreenStates.sessionId = RetrofitInstance.api.createSession(requestBody = requestToken).body()!!
            }catch (e: Exception){
                profileScreenStates.isUserLoggedOut = true
                generalOperations.showErrorAccessingAccountMessage(context = context)
                return@launch
            }
        }
    }

    private fun deleteSession(context: Context, requestBody: okhttp3.RequestBody) {
        viewModelScope.launch {
            try {
                getProfileScreenContent(context = context)
                profileScreenStates.sessionDeletion = RetrofitInstance.api.deleteSession(body = requestBody).body()!!
                generalOperations.showToast(context = context, "Logged Out")
                profileScreenStates.isUserLoggedOut = true
            }catch (e: Exception){
                generalOperations.showToast(context = context, "Log Out Failed")
                return@launch
            }
        }
    }
    // ---------------------------------------------------------------------------------------------

    // FETCH PROFILE DATA --------------------------------------------------------------------------
    fun getProfileScreenContent(context: Context) {
        viewModelScope.launch {
            try {
                if (profileScreenStates.sessionId.session_id.isNotEmpty() && profileScreenStates.isPermissionGranted) {
                    getUserDetails()
                    getFavoriteMovies()
                    getFavoriteTvSeries()
                    getMoviesOnWatchList()
                    getTvSeriesOnWatchList()
                    profileScreenStates.isPermissionGranted = false
                }
            } catch (e: Exception) {
                generalOperations.showErrorLoadingDataMessage(context = context, "Profile Data")
                return@launch
            }
        }
    }

    private suspend fun getUserDetails() {
        profileScreenStates.userDetails = RetrofitInstance.api.getUserDetails(
            sessionId = profileScreenStates.sessionId.session_id).body()!!
    }

    private suspend fun getMoviesOnWatchList() {
        profileScreenStates.moviesOnWatchList = RetrofitInstance.api.getMoviesOnWatchList(
            accountId = profileScreenStates.userDetails.id,
            sessionId = profileScreenStates.sessionId.session_id).body()!!
    }

    private suspend fun getTvSeriesOnWatchList() {
        profileScreenStates.tvSeriesOnWatchList = RetrofitInstance.api.getTvSeriesOnWatchList(
            accountId = profileScreenStates.userDetails.id,
            sessionId = profileScreenStates.sessionId.session_id).body()!!
    }

    private suspend fun getFavoriteMovies() {
        profileScreenStates.favoriteMoviesList = RetrofitInstance.api.getFavoriteMovies(
            accountId = profileScreenStates.userDetails.id,
            sessionId = profileScreenStates.sessionId.session_id).body()!!
    }

    private suspend fun getFavoriteTvSeries() {
        profileScreenStates.favoriteTvSeriesList = RetrofitInstance.api.getFavoriteTvSeries(
            accountId = profileScreenStates.userDetails.id,
            sessionId = profileScreenStates.sessionId.session_id).body()!!
    }
    // ---------------------------------------------------------------------------------------------

    // ADD OR REMOVE FROM LIST ---------------------------------------------------------------------
    fun addOrRemoveFromWatchList(context: Context, result: String) {
        viewModelScope.launch {
            closeAddToListDialog()
            try {
                profileScreenStates.addToWatchListResponse = RetrofitInstance.api.addOrRemoveFromWatchList(
                    body = RequestBody()
                        .listItemStatusRequestBody(listType = "watchlist", result = result),
                    accountId = profileScreenStates.userDetails.id,
                    sessionId = profileScreenStates.sessionId.session_id).body()!!
                generalOperations.showListResponseMessage(
                    context = context, result = result, listType = "WatchList")
                determineWhichListToUpdate(listType = "watchlist")
            } catch (e: Exception) {
                generalOperations.showErrorAddingToListMessage(context = context, result = result, listType = "WatchList")
                return@launch
            }
        }
    }

    fun addOrRemoveFromFavoritesList(context: Context, result: String) {
        viewModelScope.launch {
            closeAddToListDialog()
            try {
                profileScreenStates.addToFavoriteListResponse = RetrofitInstance.api.addOrRemoveFromFavoriteList(
                    body = RequestBody()
                        .listItemStatusRequestBody(listType = "favorite", result = result),
                    accountId = profileScreenStates.userDetails.id,
                    sessionId = profileScreenStates.sessionId.session_id).body()!!
                generalOperations.showListResponseMessage(
                    context = context, result = result, listType = "Favorites")
                determineWhichListToUpdate(listType = "favorite")
            } catch (e: Exception) {
                generalOperations.showErrorAddingToListMessage(context = context, result = result, listType = "Favorites")
                return@launch
            }
        }
    }
    // ---------------------------------------------------------------------------------------------

    inline fun manageAddToListDialogButtonOnClickState(
        listOne: List<Any>,
        listTwo: List<Any>,
        removeFunction: () -> Unit,
        addFunction: () -> Unit
    ) {
        sharedStates.selectedMediaItem.let {
            if (it in listOne ||
                it in listTwo
            ) { removeFunction() } else addFunction() }
    }

    fun determineAddToListDialogButtonActionText(
        listOne: List<Any>,
        listTwo: List<Any>
    ): String {
        return sharedStates.selectedMediaItem.let {
            if (it in listOne ||
                it in listTwo
            ) { "Remove From" } else "Add To" }
    }

    private suspend fun determineWhichListToUpdate(listType: String) {
        when (sharedStates.selectedMediaItem) {
            is Movie -> determineMovieListType(listType = listType)
            is TvSeries -> determineTvListType(listType = listType)
            is CelebrityMovieCast -> determineMovieListType(listType = listType)
            is CelebrityTvCast -> determineTvListType(listType = listType)
        }
    }

    private suspend fun determineMovieListType(listType: String) {
        if (listType == "watchlist") getMoviesOnWatchList() else getFavoriteMovies()
    }

    private suspend fun determineTvListType(listType: String) {
        if (listType == "watchlist") getTvSeriesOnWatchList() else getFavoriteTvSeries()
    }

    fun selectMediaToAddToList(mediaItem: Any) {
        sharedStates.selectedMediaItem = mediaItem
        if (sharedStates.selectedMediaItem is Movie || sharedStates.selectedMediaItem is CelebrityMovieCast ||
            sharedStates.selectedMediaItem is TvSeries || sharedStates.selectedMediaItem is CelebrityTvCast) {
            AddToListDialogStates.isAddToListDialogVisible = true
        }
    }

    fun closeAddToListDialog() { AddToListDialogStates.isAddToListDialogVisible = false }

    fun getMediaType(mediaItem: Any): String {
        return when (mediaItem) {
            is Movie -> "movie"
            is TvSeries -> "tv"
            is CelebrityMovieCast -> "movie"
            is CelebrityTvCast -> "tv"
            else -> {""}
        }
    }

    fun getMediaId(mediaItem: Any): Int {
        return when (mediaItem) {
            is Movie -> mediaItem.id
            is TvSeries -> mediaItem.id
            is CelebrityMovieCast -> mediaItem.id
            is CelebrityTvCast -> mediaItem.id
            else -> {0}
        }
    }
}
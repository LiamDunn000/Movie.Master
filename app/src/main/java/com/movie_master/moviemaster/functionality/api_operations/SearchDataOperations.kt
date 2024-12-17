package com.movie_master.moviemaster.functionality.api_operations

import android.content.Context
import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_dimensions.MediaSearchBarDimensions
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_states.mediaSearchBarStates
import com.movie_master.moviemaster.functionality.general_operations.generalOperations
import kotlinx.coroutines.launch
import java.io.IOException

val searchDataOperations = SearchDataOperations()

class SearchDataOperations: ViewModel() {

    // Function That Closes The Media Search Bar
    fun closeMediaSearchBar() { mediaSearchBarStates.isMediaSearchBarExpanded = false
    }

    // Function That Clears The Media Search Bar Focus
    fun clearMediaSearchBarFocus() { mediaSearchBarStates.isMediaSearchBarTextFieldFocused = false
    }

    // FUNCTIONS FOR MANAGING MEDIA SEARCH BAR SIZE ------------------------------------------------
    fun toggleMediaSearchBarSizeBasedOnTextFieldValue() {
        mediaSearchBarStates.isMediaSearchBarExpanded = mediaSearchBarStates.mediaSearchBarTextFieldValue != ""
    }

    // Function That Toggles The Size Of The Media Search Bar Based On Text Field Focus
    fun toggleMediaSearchBarSizeBasedOnFocus(focusManager: FocusManager) {
        if (!mediaSearchBarStates.isMediaSearchBarTextFieldFocused){
            focusManager.clearFocus()
            mediaSearchBarStates.isMediaSearchBarExpanded = false
        } else {
            mediaSearchBarStates.isMediaSearchBarExpanded = true
        }
    }

    fun animateMediaSearchBarSize(dimensions: MediaSearchBarDimensions): Dp {
        return if (mediaSearchBarStates.mediaSearchBarTextFieldValue != "" && mediaSearchBarStates.isMediaSearchBarExpanded) dimensions.mediaSearchBarExpandedHeight.dp
        else dimensions.mediaSearchBarUnexpandedHeight.dp
    }
    // ---------------------------------------------------------------------------------------------

    // FUNCTIONS FOR SEARCHING DATA FROM API -------------------------------------------------------
    fun manageDataSearch(context: Context) {

        viewModelScope.launch {
            try {
        when (mediaSearchBarStates.selectedCategory) {

            // Search All Categories
            mediaSearchBarStates.searchableCategoryList[0] -> {
                searchMovies()
                searchTvSeries()
                searchCelebrities()
            }

            // Search Movie Category
            mediaSearchBarStates.searchableCategoryList[1] -> {
                searchMovies()
                clearTvSeriesSearch()
                clearCelebritySearch()
            }

            // Search TV Series Category
            mediaSearchBarStates.searchableCategoryList[2] -> {
                searchTvSeries()
                clearMovieSearch()
                clearCelebritySearch()
            }

            // Search Celebrity Category
            mediaSearchBarStates.searchableCategoryList[3] -> {
                searchCelebrities()
                clearMovieSearch()
                clearTvSeriesSearch()
            }
        }
        } catch (e: Exception) {
            generalOperations.showErrorLoadingDataMessage(context = context, "Search Results")
            return@launch
            }
        }
    }

    private suspend fun searchMovies() {
        mediaSearchBarStates.searchedMovieList = RetrofitInstance.api.searchMovie(query = mediaSearchBarStates.mediaSearchBarTextFieldValue).body()!!
    }

    private suspend fun searchTvSeries() {
        mediaSearchBarStates.searchedTvSeriesList = RetrofitInstance.api.searchTVSeries(query = mediaSearchBarStates.mediaSearchBarTextFieldValue).body()!!
    }

    private suspend fun searchCelebrities() {
        mediaSearchBarStates.searchedCelebrityList = RetrofitInstance.api.searchCelebrity(query = mediaSearchBarStates.mediaSearchBarTextFieldValue).body()!!
    }
    //----------------------------------------------------------------------------------------------

    // FUNCTIONS FOR CLEARING SEARCH RESULT LIST----------------------------------------------------
    private suspend fun clearMovieSearch() {
        mediaSearchBarStates.searchedMovieList = RetrofitInstance.api.searchMovie(query = "").body()!!
    }

    private suspend fun clearTvSeriesSearch() {
        mediaSearchBarStates.searchedTvSeriesList = RetrofitInstance.api.searchTVSeries(query = "").body()!!
    }

    private suspend fun clearCelebritySearch() {
        mediaSearchBarStates.searchedCelebrityList = RetrofitInstance.api.searchCelebrity(query = "").body()!!
    }
    //----------------------------------------------------------------------------------------------


}
package com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.ViewModel
import com.movie_master.moviemaster.data.api_data.celebrity._celebrity.CelebrityList
import com.movie_master.moviemaster.data.api_data.movie._movie.MovieList
import com.movie_master.moviemaster.data.api_data.tv_series._tv_series.TvSeriesList

val mediaSearchBarStates = MediaSearchBarStates()

class MediaSearchBarStates: ViewModel() {

    // Media Search Bar Text Field States
    var mediaSearchBarTextFieldValue by mutableStateOf("")
    val mediaSearchBarTextFieldFocusRequester = FocusRequester()
    var isMediaSearchBarTextFieldFocused by mutableStateOf(false)

    // Variable That Contains The State Of The Data Search Bar Expansion
    var isMediaSearchBarExpanded by mutableStateOf(false)

    // List That Contains The Categories That Can Be Searched
    var searchableCategoryList = listOf("All", "Movie", "TV Series", "Celebrity")

    // Variable That Contains The Selected Category
    var selectedCategory by mutableStateOf(searchableCategoryList[0])

    // Searched Media Lists
    var searchedMovieList by mutableStateOf(MovieList())
    var searchedTvSeriesList by mutableStateOf(TvSeriesList())
    var searchedCelebrityList by mutableStateOf(CelebrityList())
}
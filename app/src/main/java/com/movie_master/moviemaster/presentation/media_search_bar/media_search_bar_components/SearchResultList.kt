package com.movie_master.moviemaster.presentation.media_search_bar.media_search_bar_components

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_colors.MediaSearchBarColors
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_colors.mediaSearchBarColors
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_dimensions.MediaSearchBarDimensions
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_states.MediaSearchBarStates
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_states.mediaSearchBarStates

// Composable That Displays The Search Results
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun SearchResultList(
    dimensions: MediaSearchBarDimensions = MediaSearchBarDimensions(),
    colors: MediaSearchBarColors = mediaSearchBarColors,
    states: MediaSearchBarStates = mediaSearchBarStates,
    navController: NavController
) {

    // Search Result List Layout
    LazyColumn(
        modifier = Modifier
            .border(
                width = dimensions.searchResultListBorderWidth.dp,
                color = colors.searchResultListItemBorderColor
            )
            .fillMaxWidth(),
    ) {

        // Movie Search Results
        items(states.searchedMovieList.results) { movie ->

            SearchResultListItem(
                navController = navController,
                mediaItem = movie,
                details = "Movie | ${movie.release_date}"
            )
        }

        // TV Series Search Results
        items(states.searchedTvSeriesList.results) { series ->

            SearchResultListItem(
                navController = navController,
                mediaItem = series,
                details = "TV Series | ${series.first_air_date}"
            )
        }

        // Celebrity Search Results
        items(states.searchedCelebrityList.results) { celebrity ->

            SearchResultListItem(
                navController = navController,
                mediaItem = celebrity,
                details = "${celebrity.known_for_department}\n${celebrity.known_for.maxByOrNull { it.popularity }?.title}",
            )
        }
    }
}
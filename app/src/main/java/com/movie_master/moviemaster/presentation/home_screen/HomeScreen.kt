package com.movie_master.moviemaster.presentation.home_screen

import android.content.Context
import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.movie_master.moviemaster.data.home_screen_data.home_screen_colors.homeScreenColors
import com.movie_master.moviemaster.data.home_screen_data.home_screen_data_dimensions.HomeScreenDimensions
import com.movie_master.moviemaster.data.home_screen_data.home_screen_states.HomeScreenStates
import com.movie_master.moviemaster.functionality.api_operations.fetchDataOperations
import com.movie_master.moviemaster.functionality.general_operations.generalOperations
import com.movie_master.moviemaster.presentation.home_screen.home_screen_components.CategoryHeader
import com.movie_master.moviemaster.presentation.home_screen.home_screen_components.MediaSelectionList
import com.movie_master.moviemaster.presentation.media_search_bar.MediaSearchBar
import com.movie_master.moviemaster.presentation.screen_nav_bar.ScreenNavBar

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun HomeScreen (
    modifier: Modifier = Modifier,
    dimensions: HomeScreenDimensions = HomeScreenDimensions(),
    states: HomeScreenStates.Companion = HomeScreenStates.Companion,
    context: Context,
    navController: NavController) {

    BackHandler { generalOperations.closeApp(context) }

    fetchDataOperations.getHomeScreenData(context = context)

    // Portrait Home Screen Layout
    Scaffold(
        modifier.padding(WindowInsets.systemBars.asPaddingValues()),
        topBar = { MediaSearchBar(navController = navController) },
        bottomBar = { ScreenNavBar(navController = navController) },
    ) { padding ->
        LazyColumn(
            modifier
                .background(color = homeScreenColors.homeScreenBackgroundColor)
                .fillMaxSize()
                .padding(dimensions.homeScreenPadding.dp)
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensions.homeScreenSpacing.dp)
        ) {

            // Movies Now Playing List
            item {
                CategoryHeader(category = "IN THEATERS")
                MediaSelectionList(
                    navController = navController,
                    itemSize = "Standard",
                    mediaList = states.moviesNowPlayIngList.results,
                )
            }

            // Trending Movies List
            item {
                CategoryHeader(category = "TRENDING MOVIES")
                MediaSelectionList(
                    navController = navController,
                    itemSize = "Standard",
                    mediaList = states.trendingMovieList.results,
                )
            }

            // Top Rated Movies List
            item {
                CategoryHeader(category = "TOP RATED CINEMA")
                MediaSelectionList(
                    navController = navController,
                    itemSize = "Large",
                    mediaList = states.topRatedMovieList.results,
                )
            }

            // TV Series On Air List
            item {
                CategoryHeader(category = "TV ON AIR")
                MediaSelectionList(
                    navController = navController,
                    itemSize = "Standard",
                    mediaList = states.tvSeriesOnAirList.results,
                )
            }

            // Trending TV Series List
            item {
                CategoryHeader(category = "TRENDING TV SERIES")
                MediaSelectionList(
                    navController = navController,
                    itemSize = "Standard",
                    mediaList = states.trendingTvSeriesList.results,
                )
            }

            // Top Rated TV Series List
            item {
                CategoryHeader(category = "TOP RATED TV SERIES")
                MediaSelectionList(
                    navController = navController,
                    itemSize = "Large",
                    mediaList = states.topRatedTvSeriesList.results,
                )
            }

            // Trending Celebrities List
            item {
                CategoryHeader(category = "CELEBRITIES OF THE WEEK")
                MediaSelectionList(
                    navController = navController,
                    itemSize = "Standard",
                    mediaList = states.trendingCelebritiesList.results,
                )
            }
        }
    }
}
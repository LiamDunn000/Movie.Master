package com.movie_master.moviemaster.presentation.profile_screen

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.movie_master.moviemaster.data.profile_screen_data.profile_screen_colors.ProfileScreenColors
import com.movie_master.moviemaster.data.profile_screen_data.profile_screen_dimensions.ProfileScreenDimensions
import com.movie_master.moviemaster.data.profile_screen_data.profile_screen_states.ProfileScreenStates
import com.movie_master.moviemaster.data.profile_screen_data.profile_screen_states.profileScreenStates
import com.movie_master.moviemaster.data.screen_nav_bar_data.screen_nav_bar_states.screenNavBarStates
import com.movie_master.moviemaster.functionality.api_operations.ManageProfileOperations
import com.movie_master.moviemaster.functionality.api_operations.manageProfileOperations
import com.movie_master.moviemaster.functionality.api_operations.searchDataOperations
import com.movie_master.moviemaster.presentation.home_screen.home_screen_components.CategoryHeader
import com.movie_master.moviemaster.presentation.screen_nav_bar.ScreenNavBar

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    dimensions: ProfileScreenDimensions = ProfileScreenDimensions(),
    colors: ProfileScreenColors.Companion = ProfileScreenColors.Companion,
    states: ProfileScreenStates = profileScreenStates,
    operations: ManageProfileOperations = manageProfileOperations,
    navController: NavController
) {

    val context = LocalContext.current

    operations.goToLoginPage(context = context)
    operations.getProfileScreenContent(context = context)

    BackHandler {
        navController.popBackStack()
        searchDataOperations.clearMediaSearchBarFocus()
        screenNavBarStates.selectedScreen = screenNavBarStates.selectableScreenList[0] }

    // Profile Screen Layout
    Scaffold(
        modifier.padding(WindowInsets.systemBars.asPaddingValues()),
        topBar = { ProfileScreenHeader() },
        bottomBar = { ScreenNavBar(navController = navController) },
    ) { padding ->
        LazyColumn(
            modifier
                .background(color = colors.profileScreenBackgroundColor)
                .fillMaxSize()
                .padding(dimensions.profileScreenPadding.dp)
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(dimensions.profileScreenSpacing.dp)
        ) {

            // Movies On Watchlist
            item {
                CategoryHeader(category = "MOVIES ON WATCHLIST")
                ProfileScreenMediaSelectionItem(
                    navController = navController,
                    list = states.moviesOnWatchList.results,
                    listType = "Movie Watchlist"
                )
            }

            // TV Series On Watchlist
            item {
                CategoryHeader(category = "TV SERIES ON WATCHLIST")
                ProfileScreenMediaSelectionItem(
                    navController = navController,
                    list = states.tvSeriesOnWatchList.results,
                    listType = "TV Series Watchlist"
                )
            }

            // Favorite Movies
            item {
                CategoryHeader(category = "FAVORITE MOVIES")
                ProfileScreenMediaSelectionItem(
                    navController = navController,
                    list = states.favoriteMoviesList.results,
                    listType = "Favorite Movies"
                )
            }

            // Favorite TV Series
            item {
                CategoryHeader(category = "FAVORITE TV SERIES")
                ProfileScreenMediaSelectionItem(
                    navController = navController,
                    list = states.favoriteTvSeriesList.results,
                    listType = "Favorite TV Series"
                )
            }
        }
    }
}

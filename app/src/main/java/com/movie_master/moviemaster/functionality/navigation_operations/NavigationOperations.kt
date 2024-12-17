package com.movie_master.moviemaster.functionality.navigation_operations

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.movie_master.moviemaster.data.details_screen_data.details_screen_states.detailsScreenStates
import com.movie_master.moviemaster.data.media_search_bar_data.media_search_bar_states.mediaSearchBarStates
import com.movie_master.moviemaster.data.profile_screen_data.profile_screen_states.profileScreenStates
import com.movie_master.moviemaster.data.screen_nav_bar_data.screen_nav_bar_states.screenNavBarStates
import com.movie_master.moviemaster.data.shared_data.sharedStates
import com.movie_master.moviemaster.functionality.api_operations.searchDataOperations
import com.movie_master.moviemaster.functionality.general_operations.generalOperations
import com.movie_master.moviemaster.functionality.user_interface_operations.userInterfaceOperations
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val navigationOperations = NavigationOperations()

class NavigationOperations: ViewModel() {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun navigateBack(context: Context, navController: NavController) {
        viewModelScope.launch {

            // Conditional That Determine Back Navigation
            if (
                // Branch That Close Media Search Bar If Expanded
                mediaSearchBarStates.isMediaSearchBarExpanded) {
                searchDataOperations.closeMediaSearchBar()
                searchDataOperations.clearMediaSearchBarFocus()
            }

            // Branch That Close App If Current Screen Is Home Screen
            else if (sharedStates.selectedMediaItemListHistory.isEmpty()){
                generalOperations.closeApp(context = context)

            // Branch That Navigate Back If Media Search Bar Is Not Expanded
            } else {
                navController.popBackStack()
                searchDataOperations.clearMediaSearchBarFocus()
                sharedStates.selectedMediaItemListHistory.removeLast()
                delay(1)

                // Nested Conditional That Loads Details For The Previous Screen
                if (sharedStates.selectedMediaItemListHistory.isNotEmpty()) {
                    userInterfaceOperations.determineMediaDetails(
                        context = navController.context,
                        mediaItem = sharedStates.selectedMediaItemListHistory.last()
                    )
                }
            }
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun navigateToDetailsScreen(
        context: Context,
        navController: NavController,
        mediaItem: Any,
    ) {
        navController.navigate(detailsScreenStates.detailsScreenDestination)
        searchDataOperations.clearMediaSearchBarFocus()
        userInterfaceOperations.determineMediaDetails(context = context, mediaItem = mediaItem)
        sharedStates.selectedMediaItemListHistory.add(mediaItem)
    }

    fun determineScreenNavBarButtonNavigation(navController: NavController) {
        if (screenNavBarStates.selectedScreen == screenNavBarStates.selectableScreenList[0]) {
            navController.popBackStack()
        searchDataOperations.clearMediaSearchBarFocus()}
        else {navController.navigate(profileScreenStates.profileScreenDestination)}
    }

}
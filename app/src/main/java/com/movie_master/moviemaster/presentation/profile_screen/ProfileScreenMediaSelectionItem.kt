package com.movie_master.moviemaster.presentation.profile_screen

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.movie_master.moviemaster.data.profile_screen_data.profile_screen_states.profileScreenStates
import com.movie_master.moviemaster.presentation.home_screen.home_screen_components.MediaSelectionList

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun ProfileScreenMediaSelectionItem(
    navController: NavController,
    list: List<Any>,
    listType: String
) {

    if (profileScreenStates.isUserLoggedOut) {
        ProfileScreenListPlaceholderText(
            listType = listType,
            conditionalType = "Login"
        )
    } else if (list.isEmpty()) {
        ProfileScreenListPlaceholderText(
                listType = listType,
                conditionalType = "Empty"
            )
    } else {
        MediaSelectionList(
            navController = navController,
            mediaList = list,
            itemSize = "Standard",
        )
    }
}


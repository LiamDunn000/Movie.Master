package com.movie_master.moviemaster

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresExtension
import androidx.compose.animation.fadeIn
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.movie_master.moviemaster.data.details_screen_data.details_screen_states.detailsScreenStates
import com.movie_master.moviemaster.data.home_screen_data.home_screen_states.HomeScreenStates
import com.movie_master.moviemaster.data.shared_data.RequestBody
import com.movie_master.moviemaster.data.profile_screen_data.profile_screen_states.profileScreenStates
import com.movie_master.moviemaster.data.shared_data.colors
import com.movie_master.moviemaster.functionality.api_operations.manageProfileOperations
import com.movie_master.moviemaster.functionality.general_operations.generalOperations
import com.movie_master.moviemaster.presentation.add_to_list_dialog.AddToListDialog
import com.movie_master.moviemaster.presentation.details_screen.DetailsScreen
import com.movie_master.moviemaster.presentation.home_screen.HomeScreen
import com.movie_master.moviemaster.presentation.profile_screen.ProfileScreen

class MainActivity : ComponentActivity() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            // Variable That Contains The System UI Controller
            val systemUiController = rememberSystemUiController()

            // Sets The Color Of The System Bars
            systemUiController.setSystemBarsColor(
                color = colors.darkBlue
            )

            val navController = rememberNavController()

            BackHandler { generalOperations.closeApp(this@MainActivity) }

            generalOperations.showToast(context = this, message = "Powered by The Movie Database")

            AddToListDialog()

                NavHost(
                    navController = navController,
                    startDestination = HomeScreenStates.homeScreenDestination,
                ) {

                    // Home Screen
                    composable(
                        route =  HomeScreenStates.homeScreenDestination,
                        enterTransition = { fadeIn() }
                        ) {
                        HomeScreen(
                            context = this@MainActivity,
                            navController = navController
                        )
                    }

                    // Details Screen
                    composable(
                        route = detailsScreenStates.detailsScreenDestination,
                        enterTransition = { fadeIn() }
                    ) {
                        DetailsScreen(
                            navController = navController
                        )

                    }

                    // Profile Screen
                    composable(
                        route = profileScreenStates.profileScreenDestination,
                        enterTransition = { fadeIn() }
                    ) {
                        ProfileScreen(
                            navController = navController
                        )
                }
            }

        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onResume() {
        super.onResume()
        if (profileScreenStates.requestToken.request_token.isNotEmpty() && profileScreenStates.isPermissionGranted) {
            manageProfileOperations.createSession(context = applicationContext, requestToken = RequestBody().createSessionRequestBody)
        }
    }
}

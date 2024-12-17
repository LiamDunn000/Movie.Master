package com.movie_master.moviemaster.presentation.screen_nav_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.movie_master.moviemaster.data.screen_nav_bar_data.screen_nav_bar_colors.screenNavBarColors
import com.movie_master.moviemaster.data.screen_nav_bar_data.screen_nav_bar_dimensions.ScreenNavBarDimensions
import com.movie_master.moviemaster.data.screen_nav_bar_data.screen_nav_bar_states.ScreenNavBarStates
import com.movie_master.moviemaster.data.screen_nav_bar_data.screen_nav_bar_states.screenNavBarStates

@Composable
fun ScreenNavBar(
    modifier: Modifier = Modifier,
    dimensions: ScreenNavBarDimensions = ScreenNavBarDimensions(),
    states: ScreenNavBarStates = screenNavBarStates,
    navController: NavController
) {

    // Screen NavBar Layout
    Row(
        modifier
            .background(screenNavBarColors.screenNavBarBackgroundColor)
            .fillMaxWidth()
    ) {

        // Home Button
        ScreenNavBarButton(
            modifier = Modifier.weight(dimensions.screenNavBarButtonWeight),
            navController = navController,
            icon = Icons.Rounded.Home,
            text = states.selectableScreenList[0],
            topEndCornerRadius = dimensions.screenNavBarButtonCornerRadius,
            bottomEndCornerRadius = dimensions.screenNavBarButtonCornerRadius
        )

        // User Button
        ScreenNavBarButton(
            modifier = Modifier.weight(dimensions.screenNavBarButtonWeight),
            navController = navController,
            icon = Icons.Rounded.AccountCircle,
            text = states.selectableScreenList[1],
            topStartCornerRadius = dimensions.screenNavBarButtonCornerRadius,
            bottomStartCornerRadius = dimensions.screenNavBarButtonCornerRadius
        )

    }
}
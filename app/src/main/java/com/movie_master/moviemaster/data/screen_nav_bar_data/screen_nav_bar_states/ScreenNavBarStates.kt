package com.movie_master.moviemaster.data.screen_nav_bar_data.screen_nav_bar_states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

val screenNavBarStates = ScreenNavBarStates()

class ScreenNavBarStates {

    var isNavBarClicked by mutableStateOf(false)

    var selectableScreenList = listOf("Home", "User")

    var selectedScreen by mutableStateOf(selectableScreenList[0])
}
package com.movie_master.moviemaster.data.profile_screen_data.profile_screen_dimensions

import com.movie_master.moviemaster.data.shared_data.screenDimensions

class ProfileScreenDimensions {

    val profileScreenPadding = screenDimensions.screenSize * 0.01
    val profileScreenSpacing = screenDimensions.screenSize * 0.02
    val profileScreenListPlaceHolderTextFontSize = screenDimensions.screenSize * 0.0135

    // Profile Screen Header Dimensions
    val profileScreenHeaderHeight = screenDimensions.screenSize * 0.075
    val profileScreenHeaderPadding = screenDimensions.screenSize * 0.012
    val profileImageSize = screenDimensions.screenSize * 0.05
    val userNameFontSize = screenDimensions.screenSize * 0.018
    val userNameWeight = 1f

    // Login Button Dimensions
    val loginButtonWidth = screenDimensions.screenSize * 0.072
    val loginButtonHeight = screenDimensions.screenSize * 0.035
    val loginButtonCornerRadius = screenDimensions.screenSize * 0.02
    val loginButtonFontSize = screenDimensions.screenSize * 0.012

}
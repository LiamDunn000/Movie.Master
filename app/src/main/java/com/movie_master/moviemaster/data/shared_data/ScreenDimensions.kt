package com.movie_master.moviemaster.data.shared_data

import android.content.res.Configuration

val screenDimensions: ScreenDimensions by lazy { ScreenDimensions.instance }

class ScreenDimensions(configuration: Configuration) {

    // Screen Width & Height
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    // Screen Width & Height Combined
    val screenSize = screenWidth + screenHeight

    // Uninitialized Instance of Screen Dimensions
    companion object {
        lateinit var instance: ScreenDimensions
    }
}
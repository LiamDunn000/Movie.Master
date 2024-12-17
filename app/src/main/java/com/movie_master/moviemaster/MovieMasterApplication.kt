package com.movie_master.moviemaster

import android.app.Application
import com.movie_master.moviemaster.data.shared_data.ScreenDimensions

class MovieMasterApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        ScreenDimensions.instance = ScreenDimensions(this.resources.configuration)
    }
}
package com.movie_master.moviemaster.data.shared_data

val sharedStates = SharedStates()

class SharedStates {

    var selectedMediaItem: Any = Any()

    var selectedMediaItemListHistory = mutableListOf<Any>()

    var mediaImageBaseUrl = "https://image.tmdb.org/t/p/w500/"
}
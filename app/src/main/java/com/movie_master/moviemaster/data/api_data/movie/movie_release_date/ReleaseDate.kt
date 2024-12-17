package com.movie_master.moviemaster.data.api_data.movie.movie_release_date

data class ReleaseDate(
    val certification: String,
    val descriptors: List<Any>,
    val iso_639_1: String,
    val note: String,
    val release_date: String,
    val type: Int
)
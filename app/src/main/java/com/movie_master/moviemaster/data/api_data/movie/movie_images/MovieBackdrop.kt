package com.movie_master.moviemaster.data.api_data.movie.movie_images

data class MovieBackdrop(
    val aspect_ratio: Double,
    val file_path: String,
    val height: Int,
    val iso_639_1: String,
    val vote_average: Double,
    val vote_count: Int,
    val width: Int
)
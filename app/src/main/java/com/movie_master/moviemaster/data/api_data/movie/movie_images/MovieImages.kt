package com.movie_master.moviemaster.data.api_data.movie.movie_images

data class MovieImages(
    val backdrops: List<MovieBackdrop> = listOf(),
    val id: Int = 0,
    val logos: List<MovieLogo> = listOf(),
    val posters: List<MoviePoster> = listOf()
)
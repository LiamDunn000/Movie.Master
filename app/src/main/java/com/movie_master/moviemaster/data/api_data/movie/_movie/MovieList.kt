package com.movie_master.moviemaster.data.api_data.movie._movie

data class MovieList(
    val dates: MovieDates = MovieDates(),
    val page: Int = 0,
    val results: List<Movie> = listOf(),
    val total_pages: Int = 0,
    val total_results: Int = 0
)
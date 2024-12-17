package com.movie_master.moviemaster.data.api_data.movie.movie_reviews

data class MovieReviews(
    val id: Int = 0,
    val page: Int = 0,
    val results: List<MovieReview> = listOf(),
    val total_pages: Int = 0,
    val total_results: Int = 0
)
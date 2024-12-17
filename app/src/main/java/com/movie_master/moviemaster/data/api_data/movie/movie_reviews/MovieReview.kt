package com.movie_master.moviemaster.data.api_data.movie.movie_reviews

data class MovieReview(
    val author: String,
    val author_details: AuthorDetails,
    val content: String,
    val created_at: String,
    val id: String,
    val updated_at: String,
    val url: String
)
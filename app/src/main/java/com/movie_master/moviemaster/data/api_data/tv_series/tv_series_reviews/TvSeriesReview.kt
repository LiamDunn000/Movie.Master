package com.movie_master.moviemaster.data.api_data.tv_series.tv_series_reviews

data class TvSeriesReview(
    val author: String ,
    val author_details: AuthorDetails,
    val content: String,
    val created_at: String,
    val id: String,
    val updated_at: String,
    val url: String
)
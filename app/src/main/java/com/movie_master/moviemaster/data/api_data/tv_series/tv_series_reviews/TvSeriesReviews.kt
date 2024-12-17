package com.movie_master.moviemaster.data.api_data.tv_series.tv_series_reviews

data class TvSeriesReviews(
    val id: Int = 0,
    val page: Int = 0,
    val results: List<TvSeriesReview> = listOf(),
    val total_pages: Int = 0,
    val total_results: Int = 0
)
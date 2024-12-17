package com.movie_master.moviemaster.data.api_data.tv_series.tv_series_content_rating

data class TvContentRating(
    val id: Int = 0,
    val results: List<TvSeriesContentRatingResult> = listOf()
)
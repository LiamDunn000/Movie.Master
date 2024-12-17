package com.movie_master.moviemaster.data.api_data.tv_series._tv_series

data class TvSeriesList(
    val page: Int = 0,
    val results: List<TvSeries> = listOf(),
    val total_pages: Int = 0,
    val total_results: Int = 0
)
package com.movie_master.moviemaster.data.api_data.tv_series.tv_series_images

data class TvSeriesImages(
    val backdrops: List<TvSeriesBackdrop> = listOf(),
    val id: Int = 0,
    val logos: List<TvSeriesLogo> = listOf(),
    val posters: List<TvSeriesPoster> = listOf()
)
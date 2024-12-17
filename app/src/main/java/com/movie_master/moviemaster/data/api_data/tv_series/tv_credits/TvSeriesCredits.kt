package com.movie_master.moviemaster.data.api_data.tv_series.tv_credits

data class TvSeriesCredits(
    val cast: List<TvSeriesCast> = listOf(),
    val crew: List<TvSeriesCrew> = listOf(),
    val id: Int = 0
)
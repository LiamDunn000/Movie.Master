package com.movie_master.moviemaster.data.api_data.tv_series.tv_series_details

data class LastEpisodeToAir(
    val air_date: String = "",
    val episode_number: Int = 0,
    val id: Int = 0,
    val name: String = "",
    val overview: String = "",
    val production_code: String = "",
    val runtime: Int = 0,
    val season_number: Int = 0,
    val show_id: Int = 0,
    val still_path: String = "",
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)
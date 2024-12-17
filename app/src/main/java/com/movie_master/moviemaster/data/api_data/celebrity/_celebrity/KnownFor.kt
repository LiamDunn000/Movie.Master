package com.movie_master.moviemaster.data.api_data.celebrity._celebrity

data class KnownFor(
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val genre_ids: List<Int> = listOf(),
    val id: Int = 0,
    val media_type: String = "",
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String,
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)
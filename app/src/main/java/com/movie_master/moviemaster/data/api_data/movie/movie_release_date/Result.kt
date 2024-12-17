package com.movie_master.moviemaster.data.api_data.movie.movie_release_date

data class Result(
    val iso_3166_1: String,
    val release_dates: List<ReleaseDate>
)
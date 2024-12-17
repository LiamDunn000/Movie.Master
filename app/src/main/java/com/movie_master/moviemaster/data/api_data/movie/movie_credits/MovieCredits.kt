package com.movie_master.moviemaster.data.api_data.movie.movie_credits

data class MovieCredits(
    val cast: List<MovieCast> = listOf(),
    val crew: List<MovieCrew> = listOf(),
    val id: Int = 0
)
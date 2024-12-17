package com.movie_master.moviemaster.data.api_data.celebrity.celebrity_movie_credits

data class CelebrityMovieCredits(
    val cast: List<CelebrityMovieCast> = listOf(),
    val crew: List<CelebrityMovieCrew> = listOf(),
    val id: Int = 0
)
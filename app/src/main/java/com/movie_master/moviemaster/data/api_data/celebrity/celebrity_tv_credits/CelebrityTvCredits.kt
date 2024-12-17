package com.movie_master.moviemaster.data.api_data.celebrity.celebrity_tv_credits

data class CelebrityTvCredits(
    val cast: List<CelebrityTvCast> = listOf(),
    val crew: List<CelebrityTvCrew> = listOf(),
    val id: Int = 0
)
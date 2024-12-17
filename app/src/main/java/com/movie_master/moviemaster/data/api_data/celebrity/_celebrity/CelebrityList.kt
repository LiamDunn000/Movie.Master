package com.movie_master.moviemaster.data.api_data.celebrity._celebrity

data class CelebrityList(
    val page: Int = 0,
    val results: List<Celebrity> = listOf(),
    val total_pages: Int = 0,
    val total_results: Int = 0
)
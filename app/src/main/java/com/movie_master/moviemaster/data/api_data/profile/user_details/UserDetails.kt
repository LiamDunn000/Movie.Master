package com.movie_master.moviemaster.data.api_data.profile.user_details

data class UserDetails(
    val avatar: Avatar = Avatar(),
    val id: Int = 0,
    val include_adult: Boolean = false,
    val iso_3166_1: String = "",
    val iso_639_1: String = "",
    val name: String = "",
    val username: String = ""
)
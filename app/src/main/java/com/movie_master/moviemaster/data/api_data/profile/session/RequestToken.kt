package com.movie_master.moviemaster.data.api_data.profile.session

data class RequestToken(
    val expires_at: String = "",
    val request_token: String = "",
    val success: Boolean = false
)
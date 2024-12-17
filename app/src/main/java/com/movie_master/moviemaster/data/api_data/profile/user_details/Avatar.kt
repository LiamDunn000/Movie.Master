package com.movie_master.moviemaster.data.api_data.profile.user_details

data class Avatar(
    val gravatar: Gravatar = Gravatar(),
    val tmdb: Tmdb = Tmdb()
)
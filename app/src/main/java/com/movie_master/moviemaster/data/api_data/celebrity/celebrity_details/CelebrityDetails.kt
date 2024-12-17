package com.movie_master.moviemaster.data.api_data.celebrity.celebrity_details

data class CelebrityDetails(
    val adult: Boolean = false,
    val also_known_as: List<String> = listOf(),
    val biography: String = "",
    val birthday: String = "",
    val deathday: String = "",
    val gender: Int = 0,
    val homepage: Any = Any(),
    val id: Int = 0,
    val imdb_id: String = "",
    val known_for_department: String = "",
    val name: String = "",
    val place_of_birth: String = "",
    val popularity: Double = 0.0,
    val profile_path: String = ""
)
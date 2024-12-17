package com.movie_master.moviemaster.data.api_data.celebrity._celebrity

data class Celebrity(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val known_for: List<KnownFor> = listOf(),
    val known_for_department: String,
    val name: String,
    val original_name: String,
    val popularity: Double,
    val profile_path: String
)
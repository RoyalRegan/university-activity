package com.jaju.kursach_core.data.tmdb.model.fully.person

import com.fasterxml.jackson.annotation.JsonProperty

data class Person(
        val birthday: String?,
        @JsonProperty("known_for_department")
        val knownForDepartment: String,
        val deathday: String?,
        val id: Int,
        val name: String,
        @JsonProperty("also_known_as")
        val alsoKnownAs: ArrayList<String>,
        val gender: Int,
        val biography: String,
        val popularity: Double,
        @JsonProperty("place_of_birth")
        val placeOfBirth: String?,
        @JsonProperty("profile_path")
        val profilePath: String?,
        val adult: Boolean,
        @JsonProperty("imdb_id")
        val imdbId: String,
        val homepage: String?)
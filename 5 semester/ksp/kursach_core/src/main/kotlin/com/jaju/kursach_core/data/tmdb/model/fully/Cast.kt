package com.jaju.kursach_core.data.tmdb.model.fully

import com.fasterxml.jackson.annotation.JsonProperty

data class Cast(
        @JsonProperty("cast_id")
        val castId: Int,
        val character: String,
        @JsonProperty("credit_id")
        val creditId: String,
        val gender: Int,
        val id: Int,
        val name: String,
        val order: Int,
        @JsonProperty("profile_path")
        val profilePath: String?)
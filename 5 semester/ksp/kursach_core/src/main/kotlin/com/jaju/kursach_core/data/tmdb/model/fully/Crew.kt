package com.jaju.kursach_core.data.tmdb.model.fully

import com.fasterxml.jackson.annotation.JsonProperty

data class Crew(
        @JsonProperty("credit_id")
        val creditId: String,
        val department: String,
        val gender: Int,
        val id: Int,
        val job: String,
        val name: String,
        @JsonProperty("profile_path")
        val profilePath: String?)
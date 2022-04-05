package com.jaju.kursach_core.data.tmdb.model.fully.movie

import com.fasterxml.jackson.annotation.JsonProperty

data class SpokenLanguage(
        @JsonProperty("iso_639_1")
        val isoCode: String,
        val name: String)
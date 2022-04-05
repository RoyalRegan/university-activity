package com.jaju.kursach_core.data.tmdb.model.fully.movie

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductionCountry(
        @JsonProperty("iso_3166_1")
        val isoCode: String,
        val name: String)
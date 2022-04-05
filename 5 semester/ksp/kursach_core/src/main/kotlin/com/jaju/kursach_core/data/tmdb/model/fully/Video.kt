package com.jaju.kursach_core.data.tmdb.model.fully

import com.fasterxml.jackson.annotation.JsonProperty

data class Video(val id: String,
                 @JsonProperty("iso_639_1")
                 val isoCode: String,
                 @JsonProperty("iso_3166_1")
                 val isooCode: String,
                 val key: String,
                 val name: String,
                 val site: String,
                 val size: Int,
                 val type: String)
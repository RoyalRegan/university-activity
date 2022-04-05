package com.jaju.kursach_core.data.tmdb.model.fully

import com.fasterxml.jackson.annotation.JsonProperty

data class Image(
        @JsonProperty("aspect_ratio")
        val aspectRatio: Double,
        @JsonProperty("file_path")
        val filePath: String,
        val height: Int,
        @JsonProperty("iso_639_1")
        val isoCode: String?,
        @JsonProperty("vote_average")
        val voteAverage: Int,
        @JsonProperty("vote_count")
        val voteCount: Int,
        val width: Int)
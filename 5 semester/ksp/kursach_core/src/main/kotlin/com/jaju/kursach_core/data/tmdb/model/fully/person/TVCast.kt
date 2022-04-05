package com.jaju.kursach_core.data.tmdb.model.fully.person

import com.fasterxml.jackson.annotation.JsonProperty

data class TVCast(
        @JsonProperty("credit_id")
        val creditId: String,
        @JsonProperty("original_name")
        val originalName: String,
        val id: Int,
        @JsonProperty("genre_ids")
        val genreIds: ArrayList<Int>,
        val character: String,
        val name: String,
        @JsonProperty("poster_path")
        val posterPath: String?,
        @JsonProperty("vote_count")
        val voteCount: Int,
        @JsonProperty("vote_average")
        val voteAverage: Double,
        val popularity: Double,
        @JsonProperty("episode_count")
        val episodeCount: Int,
        @JsonProperty("original_language")
        val originalLanguage: String,
        @JsonProperty("first_air_date")
        val firstAirDate: String,
        @JsonProperty("backdrop_path")
        val backdropPath: String?,
        val overview: String,
        @JsonProperty("origin_country")
        val originCountry: ArrayList<String>)
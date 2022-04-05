package com.jaju.kursach_core.data.tmdb.model.fully.person

import com.fasterxml.jackson.annotation.JsonProperty

data class MixedCast(
        val character: String?,
        @JsonProperty("credit_id")
        val creditId: String,
        @JsonProperty("release_date")
        val releaseDate: String?,
        @JsonProperty("vote_count")
        val voteCount: Int,
        val video: Boolean,
        val adult: Boolean,
        @JsonProperty("vote_average")
        val voteAverage: Double,
        val title: String?,
        @JsonProperty("genre_ids")
        val genreIds: ArrayList<Int>,
        @JsonProperty("original_language")
        val originalLanguage: String,
        @JsonProperty("original_title")
        val originalTitle: String?,
        val popularity: Double,
        val id: Int,
        @JsonProperty("backdrop_path")
        val backdropPath: String?,
        val overview: String,
        @JsonProperty("poster_path")
        val posterPath: String?,
        @JsonProperty("episode_count")
        val episodeCount: Int,
        @JsonProperty("origin_country")
        val originCountry: ArrayList<String>?,
        @JsonProperty("original_name")
        val originalName: String?,
        val name: String?,
        @JsonProperty("media_type")
        val mediaType: String,
        @JsonProperty("first_air_date")
        val firstAirDate: String?)
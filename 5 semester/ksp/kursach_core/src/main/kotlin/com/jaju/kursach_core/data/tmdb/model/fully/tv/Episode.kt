package com.jaju.kursach_core.data.tmdb.model.fully.tv

import com.fasterxml.jackson.annotation.JsonProperty

data class Episode(
        @JsonProperty("air_date")
        val airDate: String,
        val id: Int,
        @JsonProperty("episode_number")
        val episodeNumber: Int,
        val name: String,
        val overview: String,
        @JsonProperty("production_code")
        val productionCode: String?,
        @JsonProperty("season_number")
        val seasonNumber: Int,
        @JsonProperty("show_id")
        val showId: Int,
        @JsonProperty("still_path")
        val stillPath: String?,
        @JsonProperty("vote_average")
        val voteAverage: Double,
        @JsonProperty("vote_count")
        val voteCount: Int)
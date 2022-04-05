package com.jaju.kursach_core.data.tmdb.model.fully.tv

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.jaju.kursach_core.data.tmdb.model.fully.ProductionCompany
import com.jaju.kursach_core.data.tmdb.model.simple.AbstractWatchObject

@JsonDeserialize
data class TV(
        @JsonProperty("poster_path")
        override val posterPath: String?,
        @JsonProperty("backdrop_path")
        override val backdropPath: String?,
        override val overview: String?,
        @JsonProperty("original_language")
        override val originalLanguage: String,
        @JsonProperty("vote_count")
        override val voteCount: Int,
        @JsonProperty("vote_average")
        override val voteAverage: Double,
        override val id: Int,
        override val name: String,
        override val popularity: Double,
        val homepage: String,
        @JsonProperty("in_production")
        val inProduction: Boolean,
        val languages: ArrayList<String>,
        @JsonProperty("last_air_date")
        val lastAirDate: String,
        @JsonProperty("last_episode_to_air")
        val lastEpisodeToAir: Episode,
        @JsonProperty("next_episode_to_air")
        val nextEpisodeToAir: Episode?,
        val networks: ArrayList<ProductionCompany>,
        @JsonProperty("number_of_episodes")
        val numberOfEpisodes: Int,
        @JsonProperty("number_of_seasons")
        val numberOfSeasons: Int,
        @JsonProperty("origin_country")
        val originCountry: ArrayList<String>,
        @JsonProperty("original_name")
        val originalName: String,
        @JsonProperty("production_companies")
        val productionCompanies: ArrayList<ProductionCompany>,
        val status: String,
        val type: String) : AbstractWatchObject()
package com.jaju.kursach_core.data.tmdb.model.simple

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonDeserialize
data class SimpleTV(override val id: Int,
                    override val overview: String,
                    @JsonProperty(value = "poster_path")
                    override val posterPath: String?,
                    @JsonProperty(value = "genre_ids")
                    val genreIds: ArrayList<Int>,
                    @JsonProperty(value = "original_language")
                    override val originalLanguage: String,
                    @JsonProperty(value = "backdrop_path")
                    override val backdropPath: String?,
                    override val popularity: Double,
                    @JsonProperty(value = "vote_count")
                    override val voteCount: Int,
                    @JsonProperty(value = "vote_average")
                    override val voteAverage: Double,
                    @JsonProperty(value = "name")
                    override val name: String,
                    @JsonProperty(value = "first_air_date")
                    val firstAirDate: String,
                    @JsonProperty(value = "origin_country")
                    val originCountry: ArrayList<String>,
                    @JsonProperty(value = "original_name")
                    val originalName: String) : AbstractWatchObject()
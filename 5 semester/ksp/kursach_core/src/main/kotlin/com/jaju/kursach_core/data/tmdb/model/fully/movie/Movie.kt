package com.jaju.kursach_core.data.tmdb.model.fully.movie

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.jaju.kursach_core.data.tmdb.model.fully.Genre
import com.jaju.kursach_core.data.tmdb.model.fully.ProductionCompany
import com.jaju.kursach_core.data.tmdb.model.simple.AbstractWatchObject
import java.math.BigInteger

@JsonDeserialize
data class Movie(val adult: Boolean,
                 @JsonProperty("backdrop_path")
                 override val backdropPath: String?,
                 @JsonProperty("belongs_to_collection")
                 val belongsToCollection: Any?,
                 val budget: Int,
                 val genres: ArrayList<Genre>,
                 val homepage: String?,
                 override val id: Int,
                 @JsonProperty("imdb_id")
                 val imdbId: String?,
                 @JsonProperty("original_language")
                 override val originalLanguage: String,
                 @JsonProperty("original_title")
                 val originalTitle: String,
                 override val overview: String?,
                 override val popularity: Double,
                 @JsonProperty("poster_path")
                 override val posterPath: String?,
                 @JsonProperty("production_companies")
                 val productionCompanies: ArrayList<ProductionCompany>,
                 @JsonProperty("production_countries")
                 val productionCountries: ArrayList<ProductionCountry>,
                 @JsonProperty("release_date")
                 val releaseDate: String,
                 val revenue: BigInteger,
                 val runtime: Int?,
                 @JsonProperty("spoken_languages")
                 val spokenLanguages: ArrayList<SpokenLanguage>,
                 val status: MovieStatus,
                 val tagline: String?,
                 @JsonProperty(value = "title")
                 override val name: String,
                 val video: Boolean,
                 @JsonProperty("vote_average")
                 override val voteAverage: Double,
                 @JsonProperty("vote_count")
                 override val voteCount: Int) : AbstractWatchObject()
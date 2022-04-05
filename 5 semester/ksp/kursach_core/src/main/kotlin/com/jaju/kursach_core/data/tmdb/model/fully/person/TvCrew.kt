package com.jaju.kursach_core.data.tmdb.model.fully.person

import com.fasterxml.jackson.annotation.JsonProperty

data class TvCrew(val id: Int,
                  val department: String,
                  @JsonProperty("original_language")
                  val originalLanguage: String,
                  @JsonProperty("original_title")
                  val originalTitle: String?,
                  val job: String,
                  val overview: String,
                  @JsonProperty("vote_count")
                  val voteCount: Int,
                  val video: Boolean,
                  @JsonProperty("poster_path")
                  val posterPath: String?,
                  @JsonProperty("backdrop_path")
                  val backdropPath: String?,
                  val title: String?,
                  val popularity: Double,
                  @JsonProperty("genre_ids")
                  val genreIds: ArrayList<Int>,
                  @JsonProperty("vote_average")
                  val voteAverage: Double,
                  val adult: Boolean,
                  @JsonProperty("release_date")
                  val releaseDate: String?,
                  @JsonProperty("credit_id")
                  val creditId: String,
                  @JsonProperty("episode_count")
                  val episodeCount: Int,
                  @JsonProperty("origin_country")
                  val originCountry: ArrayList<String>,
                  @JsonProperty("original_name")
                  val originalName:String,
                  val name:String,
                  @JsonProperty("first_air_date")
                  val firstAirDate:String)
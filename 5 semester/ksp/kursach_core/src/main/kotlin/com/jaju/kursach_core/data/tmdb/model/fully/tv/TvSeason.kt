package com.jaju.tmdb_service.web.tmdbApi.model.fully.tv

import com.fasterxml.jackson.annotation.JsonProperty
import com.jaju.kursach_core.data.tmdb.model.fully.tv.Episode

data class TvSeason(
        val _id: String,
        val id: Int,
        @JsonProperty("air_date")
        val airDate: String,
        val episodes: ArrayList<Episode>,
        val name: String,
        val overview: String,
        @JsonProperty("poster_path")
        val posterPath: String,
        @JsonProperty("season_number")
        val seasonNumber: Int)
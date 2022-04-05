package com.jaju.kursach_core.data.tmdb.model

import com.fasterxml.jackson.annotation.JsonProperty

class ResultResponseDates<T>(
        val page: Int,
        val results: Array<T>,
        @JsonProperty(value = "total_results")
        val totalResults: Int,
        val dates:Dates,
        @JsonProperty(value = "total_pages")
        val totalPages: Int
)
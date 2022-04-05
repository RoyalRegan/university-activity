package com.jaju.kursach_core.data.tmdb.model.fully.movie

import com.fasterxml.jackson.annotation.JsonProperty

enum class MovieStatus {
    @JsonProperty("Rumored")
    RUMORED,
    @JsonProperty("Planned")
    PLANNED,
    @JsonProperty("In Production")
    IN_PRODUCTION,
    @JsonProperty("Post Production")
    POST_PRODUCTION,
    @JsonProperty("Released")
    RELEASED,
    @JsonProperty("Canceled")
    CANCELED
}
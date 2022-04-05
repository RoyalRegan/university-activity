package com.jaju.where2skate.data.dao.rink.params

import com.fasterxml.jackson.annotation.JsonProperty

enum class OpenHours {
    @JsonProperty(value = "m")
    M,
    @JsonProperty(value = "a")
    A,
    @JsonProperty(value = "p")
    P,
    @JsonProperty(value = "n")
    N;

    override fun toString(): String {
        return super.toString().toLowerCase()
    }
}
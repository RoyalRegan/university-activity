package com.jaju.kursach_core.data.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class UserRate(
        @JsonProperty("object_id")
        val objectId: Int,
        val review: String?,
        val score: Double?) : Serializable
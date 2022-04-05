package com.jaju.kursach_core.data.tmdb.model.simple

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonDeserialize
data class SimplePerson(override val id: Int,
                        override val name: String,
                        override val popularity: Double,
                        val adult: Boolean,
                        val profilePath: String?,
                        @JsonProperty(value = "known_for")
                        val knownFor: ArrayList<AbstractWatchObject>) : AbstractSimpleObject()
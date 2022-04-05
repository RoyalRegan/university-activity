package com.jaju.kursach_core.data.tmdb.model.simple

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.jaju.kursach_core.util.deserealize.AbstractSimpleObjectDeserializer

@JsonDeserialize(using = AbstractSimpleObjectDeserializer::class)
abstract class AbstractSimpleObject {
    abstract val id: Int
    abstract val name: String
    abstract val popularity: Double
}
package com.jaju.kursach_core.util.deserealize

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.jaju.kursach_core.data.tmdb.model.simple.AbstractSimpleObject
import com.jaju.kursach_core.data.tmdb.model.simple.SimpleMovie
import com.jaju.kursach_core.data.tmdb.model.simple.SimplePerson
import com.jaju.kursach_core.data.tmdb.model.simple.SimpleTV
import com.jaju.kursach_core.util.containNode

class AbstractSimpleObjectDeserializer : StdDeserializer<AbstractSimpleObject>(AbstractSimpleObject::class.java) {
    override fun deserialize(parser: JsonParser, context: DeserializationContext): AbstractSimpleObject {
        val mapper = parser.codec as ObjectMapper
        val root = parser.codec.readTree<JsonNode>(parser)
        if (root.containNode("video")) {
            return mapper.treeToValue(root, SimpleMovie::class.java)
        }
        if (root.containNode("first_air_date")) {
            return mapper.treeToValue(root, SimpleTV::class.java)
        }
        if (root.containNode("known_for")) {
            return mapper.treeToValue(root, SimplePerson::class.java)
        }
        throw RuntimeException("Unsupported type of object")
    }
}
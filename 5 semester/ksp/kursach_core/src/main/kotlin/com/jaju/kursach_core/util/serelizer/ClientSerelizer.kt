package com.jaju.kursach_core.util.serelizer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.jaju.kursach_core.data.model.Client

class ClientSerelizer : StdSerializer<Client>(Client::class.java) {

    override fun serialize(p0: Client, p1: JsonGenerator, p2: SerializerProvider) {
        p1.writeString(p0.login)
    }
}
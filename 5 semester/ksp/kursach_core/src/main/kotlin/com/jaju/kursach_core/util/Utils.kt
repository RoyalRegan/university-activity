package com.jaju.kursach_core.util

import com.fasterxml.jackson.databind.JsonNode

fun JsonNode.containNode(name: String): Boolean = this.get(name) != null

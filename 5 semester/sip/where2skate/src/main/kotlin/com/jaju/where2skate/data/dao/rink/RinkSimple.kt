package com.jaju.where2skate.data.dao.rink

import com.fasterxml.jackson.annotation.JsonProperty
import com.jaju.where2skate.data.dao.rink.params.OpenHours

data class RinkSimple(val id: Int,
                      val latitude: Double,
                      val longitude: Double,
                      val type: String,
                      val name: String,
                      val free: Int,
                      @JsonProperty(value = "open_hours")
                      val openHours: List<OpenHours>,
                      val rating: Double)
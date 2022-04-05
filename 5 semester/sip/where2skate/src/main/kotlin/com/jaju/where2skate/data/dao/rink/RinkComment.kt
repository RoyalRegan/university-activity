package com.jaju.where2skate.data.dao.rink

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class RinkComment(val id: Int?,
                       @JsonProperty(value = "user_name")
                       val userName: String?,
                       @JsonProperty(value = "rink_id")
                       val rinkId: Int,
                       val text: String,
                       val score: Double?,
                       val karma: Int?,
                       val deleted: Int?,
                       val date: Date?,
                       @JsonProperty(value = "user_rate")
                       val userRate: Int?)
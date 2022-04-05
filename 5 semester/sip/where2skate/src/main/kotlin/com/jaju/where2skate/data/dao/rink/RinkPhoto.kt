package com.jaju.where2skate.data.dao.rink

import com.fasterxml.jackson.annotation.JsonProperty

data class RinkPhoto(val id: Int,
                     @JsonProperty(value = "rink_id")
                     val rinkId: Int,
                     val url: String)
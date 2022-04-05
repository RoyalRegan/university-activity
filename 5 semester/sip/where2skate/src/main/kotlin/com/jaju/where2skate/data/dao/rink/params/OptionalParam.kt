package com.jaju.where2skate.data.dao.rink.params

import com.fasterxml.jackson.annotation.JsonProperty

data class OptionalParam(@JsonProperty(value = "param_type") val paramType: OptionalParams,
                         val value: Int)
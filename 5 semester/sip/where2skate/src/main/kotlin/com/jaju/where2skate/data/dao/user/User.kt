package com.jaju.where2skate.data.dao.user

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

data class User(val uuid: String,
                val nickname: String,
                @JsonProperty(value = "image_url")
                val imageUrl: String?,
                @JsonIgnore
                val moderator: Int)
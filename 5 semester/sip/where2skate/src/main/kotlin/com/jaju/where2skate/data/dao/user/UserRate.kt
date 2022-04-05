package com.jaju.where2skate.data.dao.user

import com.fasterxml.jackson.annotation.JsonProperty

data class UserRate(val id: Int?,
                    @JsonProperty(value = "user_id")
                    val userId: String?,
                    @JsonProperty(value = "comment_id")
                    val commentId: Int,
                    val rate: Int)
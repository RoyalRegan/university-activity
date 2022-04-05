package com.jaju.where2skate.data.dao.user.admin.complain

import com.fasterxml.jackson.annotation.JsonProperty


enum class RequestTypes {
    @JsonProperty(value = "rink")
    RINK,
    @JsonProperty(value = "user")
    USER,
    @JsonProperty(value = "comment")
    COMMENT;

    override fun toString(): String {
        return super.toString().toLowerCase()
    }
}
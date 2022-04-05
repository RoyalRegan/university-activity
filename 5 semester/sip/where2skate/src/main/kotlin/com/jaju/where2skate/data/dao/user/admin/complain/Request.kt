package com.jaju.where2skate.data.dao.user.admin.complain

import com.fasterxml.jackson.annotation.JsonProperty
import java.sql.Date

data class Request(val id: Int?,
                   @JsonProperty(value = "user_id")
                   val userId: String?,
                   @JsonProperty(value = "reason_type")
                   val reasonType: Int?,
                   @JsonProperty(value = "object_type")
                   val objectType: RequestTypes,
                   @JsonProperty(value = "object_id")
                   val objectId: String,
                   @JsonProperty(value = "request_date")
                   val requestDate: Date?,
                   val info: String,
                   @JsonProperty(value = "status_id")
                   val statusId: Int?,
                   @JsonProperty(value = "last_update")
                   val lastUpdate: Date?)
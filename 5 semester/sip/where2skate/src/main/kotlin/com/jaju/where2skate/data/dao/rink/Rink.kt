package com.jaju.where2skate.data.dao.rink

import com.fasterxml.jackson.annotation.JsonProperty
import com.jaju.where2skate.data.dao.rink.params.OpenHours

data class Rink(val id: Int?,
                val latitude: Double?,
                val longitude: Double?,
                val type: String?,
                val name: String?,
                val free: Int?,
                @JsonProperty(value = "open_hours")
                val openHours: List<OpenHours>?,
                val rating: Double?,
                @JsonProperty(value = "warm_room")
                val warmRoom: Int?,
                val parking: Int?,
                @JsonProperty(value = "skates_rentals")
                val skatesRentals: Int?,
                @JsonProperty(value = "skates_sharpening")
                val skatesSharpening: Int?,
                @JsonProperty(value = "website_url")
                val websiteUrl: String?,
                @JsonProperty(value = "phone_number")
                val phoneNumber: String?)
package com.jaju.kursach_core.data.tmdb.model.fully

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductionCompany(val name: String,
                             val id: Int,
                             @JsonProperty("logo_path")
                             val logoPath: String?,
                             @JsonProperty("origin_country")
                             val originCountry: String)
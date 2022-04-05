package com.jaju.kursach_core.data.tmdb.model.fully.person

data class MixedPersonCredits(val id: Int,
                              val cast: ArrayList<MixedCast>?,
                              val crew: ArrayList<MixedCrew>)
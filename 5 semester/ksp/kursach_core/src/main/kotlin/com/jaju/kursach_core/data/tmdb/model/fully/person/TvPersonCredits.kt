package com.jaju.kursach_core.data.tmdb.model.fully.person

data class TvPersonCredits(val id: Int,
                           val cast: ArrayList<TVCast>?,
                           val crew: ArrayList<TvCrew>)
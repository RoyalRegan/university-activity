package com.jaju.kursach_core.data.tmdb.model.fully.person

data class MoviePersonCredits(val id: Int,
                              val cast: ArrayList<MovieCast>?,
                              val crew: ArrayList<MovieCrew>)
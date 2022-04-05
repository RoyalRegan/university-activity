package com.jaju.kursach_core.data.tmdb.model.fully

data class Credits(val id: Int,
                   val cast: ArrayList<Cast>,
                   val crew: ArrayList<Crew>)
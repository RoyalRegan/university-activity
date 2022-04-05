package com.jaju.kursach_core.data.tmdb.model.fully

data class Images(
        val id: Int,
        val backdrops: ArrayList<Image>,
        val posters: ArrayList<Image>)
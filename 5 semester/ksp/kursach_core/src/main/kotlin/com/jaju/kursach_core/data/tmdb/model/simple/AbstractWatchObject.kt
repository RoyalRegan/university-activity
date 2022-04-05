package com.jaju.kursach_core.data.tmdb.model.simple

abstract class AbstractWatchObject : AbstractSimpleObject() {
    abstract val posterPath: String?
    abstract val backdropPath: String?
    abstract val overview: String?
    abstract val originalLanguage: String
    abstract val voteCount: Int
    abstract val voteAverage: Double
}
package com.jaju.kursach_core.web.tmdb.controller

import com.jaju.kursach_core.data.tmdb.model.ResultResponse
import com.jaju.kursach_core.data.tmdb.model.simple.SimpleMovie
import com.jaju.kursach_core.data.tmdb.model.simple.SimpleTV
import com.jaju.kursach_core.data.tmdb.service.DiscoverService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@CrossOrigin("*")
@RestController
@RequestMapping(value = ["api/tmdb/discover/"])
class DiscoverController @Autowired constructor(val discoverService: DiscoverService) {

    @GetMapping(value = ["movie"])
    fun discoverMovies(@RequestParam requestParam: Map<String, String>): Mono<ResultResponse<SimpleMovie>> {
        return discoverService.discoverMovie(requestParam)
    }

    @GetMapping(value = ["tv"])
    fun discoverTVShows(@RequestParam requestParam: Map<String, String>): Mono<ResultResponse<SimpleTV>> {
        return discoverService.discoverTV(requestParam)
    }
}
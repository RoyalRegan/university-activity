package com.jaju.kursach_core.web.tmdb.controller

import com.jaju.kursach_core.data.tmdb.model.ResultResponse
import com.jaju.kursach_core.data.tmdb.model.simple.AbstractSimpleObject
import com.jaju.kursach_core.data.tmdb.model.simple.SimpleMovie
import com.jaju.kursach_core.data.tmdb.model.simple.SimplePerson
import com.jaju.kursach_core.data.tmdb.model.simple.SimpleTV
import com.jaju.kursach_core.data.tmdb.service.SearchService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@CrossOrigin("*")
@RestController
@RequestMapping(value = ["api/tmdb/search/"])
class SearchController @Autowired constructor(val searchService: SearchService) {

    @GetMapping(value = ["movie"])
    fun searchMovies(@RequestParam requestParam: Map<String, String>): Mono<ResultResponse<SimpleMovie>> {
        return searchService.searchMovie(requestParam)
    }

    @GetMapping(value = ["tv"])
    fun searchTVShows(@RequestParam requestParam: Map<String, String>): Mono<ResultResponse<SimpleTV>> {
        return searchService.searchTV(requestParam)
    }

    @GetMapping(value = ["person"])
    fun searchPerson(@RequestParam requestParam: Map<String, String>): Mono<ResultResponse<SimplePerson>> {
        return searchService.searchPerson(requestParam)
    }

    @GetMapping(value = ["multi"])
    fun searchMulti(@RequestParam requestParam: Map<String, String>): Mono<ResultResponse<AbstractSimpleObject>> {
        return searchService.searchMulti(requestParam)
    }
}
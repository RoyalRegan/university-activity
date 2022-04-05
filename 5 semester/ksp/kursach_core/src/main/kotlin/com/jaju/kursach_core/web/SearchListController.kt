package com.jaju.kursach_core.web

import com.jaju.kursach_core.data.model.MovieList
import com.jaju.kursach_core.data.model.TVList
import com.jaju.kursach_core.data.service.MovieService
import com.jaju.kursach_core.data.service.TVService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RestController
@RequestMapping("/api/list/search/")
class SearchListController @Autowired constructor(private val movieService: MovieService,
                                                  private val tvService: TVService) {
    @GetMapping("tv")
    fun searchTV(@RequestParam("query") query: String,
                 @RequestParam("tags") tags: LinkedHashSet<Int>?,
                 @RequestParam("page") page: Int?,
                 @RequestParam("limit") limit: Int?): Page<TVList> {
        return tvService.findList(query, tags, page, limit)
    }

    @GetMapping("movie")
    fun searchMovie(@RequestParam("query") query: String,
                    @RequestParam("tags") tags: LinkedHashSet<Int>?,
                    @RequestParam("page") page: Int?,
                    @RequestParam("limit") limit: Int?): Page<MovieList> {
        return movieService.findList(query, tags, page, limit)
    }
}
package com.jaju.kursach_core.web

import com.jaju.kursach_core.data.model.MovieList
import com.jaju.kursach_core.data.model.UserRate
import com.jaju.kursach_core.data.repository.ClientRepository
import com.jaju.kursach_core.data.service.MovieService
import com.jaju.kursach_core.security.CustomUserDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RestController
@RequestMapping("/api/list/movie")
class MovieListController @Autowired constructor(private val clientRepository: ClientRepository,
                                                 private val movieService: MovieService) {
    @GetMapping("/{id}")
    fun getMovieList(@PathVariable("id") listId: Int,
                     @AuthenticationPrincipal customUserDetails: CustomUserDetails?): MovieList? {
        return movieService.getList(listId, customUserDetails?.id)
    }

    @PostMapping
    fun createMovieList(@RequestParam("name") name: String,
                        @RequestParam("private") private: Boolean?,
                        @AuthenticationPrincipal customUserDetails: CustomUserDetails) {
        movieService.addList(name, private, clientRepository.findById(customUserDetails.id).orElseThrow())
    }

    @PostMapping("/{id}/items")
    fun addMovieToList(@PathVariable("id") listId: Int,
                       @RequestBody movieIds: ArrayList<UserRate>,
                       @AuthenticationPrincipal customUserDetails: CustomUserDetails) {
        movieService.addMovieToList(listId, movieIds, customUserDetails.id)
    }

    @PostMapping("/{id}/tags")
    fun addMovieTags(@PathVariable("id") listId: Int,
                     @RequestParam("ids") tags: ArrayList<Int>,
                     @AuthenticationPrincipal customUserDetails: CustomUserDetails) {
        movieService.addTags(listId, tags, customUserDetails.id)
    }

    @DeleteMapping("/{id}/tags")
    fun deleteMovieTags(@PathVariable("id") listId: Int,
                        @RequestParam("ids") tags: ArrayList<Int>,
                        @AuthenticationPrincipal customUserDetails: CustomUserDetails) {
        movieService.deleteTags(listId, tags, customUserDetails.id)
    }

    @DeleteMapping("/{id}/items")
    fun deleteMovieFromList(@PathVariable("id") listId: Int,
                            @RequestParam("ids") movieIds: ArrayList<Int>,
                            @AuthenticationPrincipal customUserDetails: CustomUserDetails) {
        movieService.deleteMovieFromList(listId, movieIds, customUserDetails.id)
    }

    @DeleteMapping("/{id}")
    fun deleteMovieList(@PathVariable("id") listId: Int,
                        @AuthenticationPrincipal customUserDetails: CustomUserDetails) {
        movieService.deleteMovieList(listId, customUserDetails.id)
    }

    @PutMapping("/{id}")
    fun updatePrivate(@PathVariable("id") listId: Int,
                      @AuthenticationPrincipal customUserDetails: CustomUserDetails,
                      @RequestParam("name") name: String?,
                      @RequestParam("private") private: Boolean?) {
        movieService.updateList(listId,customUserDetails.id,private,name)
    }
}
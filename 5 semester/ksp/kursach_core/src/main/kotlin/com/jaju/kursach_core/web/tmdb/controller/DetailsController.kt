package com.jaju.kursach_core.web.tmdb.controller

import com.jaju.kursach_core.data.tmdb.model.ResultResponse
import com.jaju.kursach_core.data.tmdb.model.ResultResponseDates
import com.jaju.kursach_core.data.tmdb.model.fully.Credits
import com.jaju.kursach_core.data.tmdb.model.fully.Genres
import com.jaju.kursach_core.data.tmdb.model.fully.Images
import com.jaju.kursach_core.data.tmdb.model.fully.Videos
import com.jaju.kursach_core.data.tmdb.model.fully.movie.Movie
import com.jaju.kursach_core.data.tmdb.model.fully.person.*
import com.jaju.kursach_core.data.tmdb.model.simple.SimpleMovie
import com.jaju.kursach_core.data.tmdb.model.simple.SimplePerson
import com.jaju.kursach_core.data.tmdb.service.details.DetailsService
import com.jaju.kursach_core.data.tmdb.model.fully.tv.TV
import com.jaju.tmdb_service.web.tmdbApi.model.fully.tv.TvSeason
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@CrossOrigin("*")
@RestController
@RequestMapping(value = ["api/tmdb/details/"])
class DetailsController @Autowired constructor(val detailsService: DetailsService) {

    @GetMapping("tv/genres")
    fun getTVGenres(@RequestParam params: Map<String, String>?): Mono<Genres> {
        return detailsService.getTvGenre(params)
    }

    @GetMapping("movies/genres")
    fun getMovieGenres(@RequestParam params: Map<String, String>?): Mono<Genres> {
        return detailsService.getMovieGenres(params)
    }

    @GetMapping("movie/{id}")
    fun getMovie(@PathVariable("id") id: Int,
                 @RequestParam params: Map<String, String>?): Mono<Movie> {
        return detailsService.getMovie(id, params)
    }

    @GetMapping("movie/{id}/images")
    fun getMovieImages(@PathVariable("id") id: Int,
                       @RequestParam params: Map<String, String>?): Mono<Images> {
        return detailsService.getMovieImages(id, params)
    }

    @GetMapping("movie/{id}/videos")
    fun getMovieVideos(@PathVariable("id") id: Int,
                       @RequestParam params: Map<String, String>?): Mono<Videos> {
        return detailsService.getMovieVideos(id, params)
    }

    @GetMapping("movie/{id}/similar")
    fun getSimilarMovies(@PathVariable("id") id: Int,
                         @RequestParam params: Map<String, String>?): Mono<ResultResponse<Movie>> {
        return detailsService.getSimilarMovies(id, params)
    }

    @GetMapping("movie/{id}/recommendations")
    fun getRecommendationsMovies(@PathVariable("id") id: Int,
                                 @RequestParam params: Map<String, String>?): Mono<ResultResponse<Movie>> {
        return detailsService.getRecommendationsMovies(id, params)
    }

    @GetMapping("movie/popular")
    fun getPopularMovies(@RequestParam params: Map<String, String>?): Mono<ResultResponse<Movie>> {
        return detailsService.getPopularMovies(params)
    }

    @GetMapping("movie/top_rated")
    fun getTopRatedMovies(@RequestParam params: Map<String, String>?): Mono<ResultResponse<Movie>> {
        return detailsService.getTopRatedMovies(params)
    }

    @GetMapping("movie/upcoming")
    fun getUpcomingMovies(@RequestParam params: Map<String, String>?): Mono<ResultResponseDates<SimpleMovie>> {
        return detailsService.getUpComingMovies(params)
    }

    @GetMapping("tv/{id}")
    fun getTV(@PathVariable("id") id: Int,
              @RequestParam params: Map<String, String>?): Mono<TV> {
        return detailsService.getTV(id, params)
    }

    @GetMapping("tv/{id}/images")
    fun getTVImages(@PathVariable("id") id: Int,
                    @RequestParam params: Map<String, String>?): Mono<Images> {
        return detailsService.getTVImages(id, params)
    }

    @GetMapping("tv/{id}/videos")
    fun getTVVideos(@PathVariable("id") id: Int,
                    @RequestParam params: Map<String, String>?): Mono<Videos> {
        return detailsService.getTVVideos(id, params)
    }

    @GetMapping("tv/{id}/similar")
    fun getSimilarTV(@PathVariable("id") id: Int,
                     @RequestParam params: Map<String, String>?): Mono<ResultResponse<TV>> {
        return detailsService.getSimilarTV(id, params)
    }

    @GetMapping("tv/{id}/recommendations")
    fun getRecommendationsTV(@PathVariable("id") id: Int,
                             @RequestParam params: Map<String, String>?): Mono<ResultResponse<TV>> {
        return detailsService.getRecommendationsTV(id, params)
    }

    @GetMapping("tv/popular")
    fun getPopularTV(@RequestParam params: Map<String, String>?): Mono<ResultResponse<TV>> {
        return detailsService.getPopularTV(params)
    }

    @GetMapping("tv/top_rated")
    fun getTopRatedTV(@RequestParam params: Map<String, String>?): Mono<ResultResponse<TV>> {
        return detailsService.getTopRatedTV(params)
    }

    @GetMapping("tv/{id}/seasons/{num}")
    fun getTvSeason(@PathVariable("id") id: Int,
                    @PathVariable("num") number: Int,
                    @RequestParam params: Map<String, String>?): Mono<TvSeason> {
        return detailsService.getTvSeason(id, params, number)
    }


    @GetMapping("person/{id}")
    fun getPerson(@PathVariable("id") id: Int,
                  @RequestParam params: Map<String, String>?): Mono<Person> {
        return detailsService.getPerson(id, params)
    }

    @GetMapping("person/popular")
    fun getPopularPerson(@RequestParam params: Map<String, String>?): Mono<ResultResponse<SimplePerson>> {
        return detailsService.getPopularPerson(params)
    }

    @GetMapping("person/{id}/images")
    fun getPersonImages(@PathVariable("id") id: Int,
                        @RequestParam params: Map<String, String>?): Mono<PersonImages> {
        return detailsService.getPersonImages(id, params)
    }

    @GetMapping("person/{id}/combined_credits")
    fun getPersonMixedCredits(@PathVariable("id") id: Int,
                              @RequestParam params: Map<String, String>?): Mono<MixedPersonCredits> {
        return detailsService.getPersonMixedCredits(id, params)
    }

    @GetMapping("person/{id}/movie_credits")
    fun getPersonMovieCredits(@PathVariable("id") id: Int,
                              @RequestParam params: Map<String, String>?): Mono<MoviePersonCredits> {
        return detailsService.getPersonMovieCredits(id, params)
    }

    @GetMapping("person/{id}/tv_credits")
    fun getPersonTVCredits(@PathVariable("id") id: Int,
                           @RequestParam params: Map<String, String>?): Mono<TvPersonCredits> {
        return detailsService.getPersonTVCredits(id, params)
    }

    @GetMapping("movie/{id}/credits")
    fun getMovieCredits(@PathVariable("id") id: Int,
                        @RequestParam params: Map<String, String>?): Mono<Credits> {
        return detailsService.getMovieCredits(id, params)
    }

    @GetMapping("tv/{id}/credits")
    fun getTVCredits(@PathVariable("id") id: Int,
                     @RequestParam params: Map<String, String>?): Mono<Credits> {
        return detailsService.getTVCredits(id, params)
    }
}
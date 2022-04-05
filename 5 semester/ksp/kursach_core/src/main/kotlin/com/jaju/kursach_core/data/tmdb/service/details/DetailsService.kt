package com.jaju.kursach_core.data.tmdb.service.details

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
import com.jaju.kursach_core.data.tmdb.service.details.DetailsService.DetailsServiceEndpoint.MOVIE_GENRES
import com.jaju.kursach_core.data.tmdb.service.details.DetailsService.DetailsServiceEndpoint.TV_GENRES
import com.jaju.kursach_core.web.tmdb.TMDBConfig.Companion.API_KEY
import com.jaju.kursach_core.web.tmdb.TMDBConfig.Companion.BASE_URL
import com.jaju.kursach_core.data.tmdb.model.fully.tv.TV
import com.jaju.tmdb_service.web.tmdbApi.model.fully.tv.TvSeason
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class DetailsService @Autowired constructor(val movieDetailsService: MovieDetailsService,
                                            val tvDetailsService: TvDetailsService,
                                            val peopleDetailsService: PeopleDetailsService,
                                            @Qualifier(value = "webClient") val webClient: WebClient) {

    enum class DetailsServiceEndpoint(private val endpoint: String) {
        MOVIE_GENRES("genre/movie/list"),
        TV_GENRES("genre/tv/list");

        override fun toString(): String {
            return endpoint
        }
    }

    fun buildUri(id: Int? = null, endpoint: DetailsServiceEndpoint, params: Map<String, String>?): String {
        return BASE_URL + "$endpoint?api_key=${API_KEY}${params?.map { entry -> "${entry.key}=${entry.value}" }?.joinToString(prefix = "&", separator = "&")}"
    }

    private inline fun <reified T> sendRequest(id: Int? = null, params: Map<String, String>?, endpoint: DetailsServiceEndpoint): Mono<T> {
        return webClient.get().uri(buildUri(id = id, params = params, endpoint = endpoint)).retrieve().bodyToMono(T::class.java)
    }

    fun getMovieGenres(params: Map<String, String>?): Mono<Genres> {
        return sendRequest(params = params, endpoint = MOVIE_GENRES)
    }

    fun getTvGenre(params: Map<String, String>?): Mono<Genres> {
        return sendRequest(params = params, endpoint = TV_GENRES)
    }

    fun getMovie(id: Int, params: Map<String, String>?): Mono<Movie> {
        return movieDetailsService.getMovie(id, params)
    }

    fun getMovieImages(id: Int, params: Map<String, String>?): Mono<Images> {
        return movieDetailsService.getMovieImages(id, params)
    }

    fun getMovieVideos(id: Int, params: Map<String, String>?): Mono<Videos> {
        return movieDetailsService.getMovieVideos(id, params)
    }

    fun getSimilarMovies(id: Int, params: Map<String, String>?): Mono<ResultResponse<Movie>> {
        return movieDetailsService.getSimilarMovies(id, params)
    }

    fun getRecommendationsMovies(id: Int, params: Map<String, String>?): Mono<ResultResponse<Movie>> {
        return movieDetailsService.getRecommendations(id, params)
    }

    fun getPopularMovies(params: Map<String, String>?): Mono<ResultResponse<Movie>> {
        return movieDetailsService.getPopular(params)
    }

    fun getTopRatedMovies(params: Map<String, String>?): Mono<ResultResponse<Movie>> {
        return movieDetailsService.getTopRated(params)
    }

    fun getUpComingMovies(params: Map<String, String>?): Mono<ResultResponseDates<SimpleMovie>> {
        return movieDetailsService.getUpComingMovies(params)
    }

    fun getTV(id: Int, params: Map<String, String>?): Mono<TV> {
        return tvDetailsService.getTV(id, params)
    }

    fun getTVImages(id: Int, params: Map<String, String>?): Mono<Images> {
        return tvDetailsService.getTvImages(id, params)
    }

    fun getTVVideos(id: Int, params: Map<String, String>?): Mono<Videos> {
        return tvDetailsService.getTvVideos(id, params)
    }

    fun getSimilarTV(id: Int, params: Map<String, String>?): Mono<ResultResponse<TV>> {
        return tvDetailsService.getSimilarMovies(id, params)
    }

    fun getRecommendationsTV(id: Int, params: Map<String, String>?): Mono<ResultResponse<TV>> {
        return tvDetailsService.getRecommendations(id, params)
    }

    fun getPopularTV(params: Map<String, String>?): Mono<ResultResponse<TV>> {
        return tvDetailsService.getPopular(params)
    }

    fun getTopRatedTV(params: Map<String, String>?): Mono<ResultResponse<TV>> {
        return tvDetailsService.getTopRated(params)
    }

    fun getTvSeason(id: Int, params: Map<String, String>?, seasonNum: Int): Mono<TvSeason> {
        return tvDetailsService.getTvSeason(id, params, seasonNum)
    }


    fun getPerson(id: Int, params: Map<String, String>?): Mono<Person> {
        return peopleDetailsService.getPerson(id, params);
    }

    fun getPopularPerson(params: Map<String, String>?): Mono<ResultResponse<SimplePerson>> {
        return peopleDetailsService.getPopularPerson(params);
    }

    fun getPersonImages(id: Int, params: Map<String, String>?): Mono<PersonImages> {
        return peopleDetailsService.getPersonImages(id, params)
    }

    fun getPersonMovieCredits(id: Int, params: Map<String, String>?): Mono<MoviePersonCredits> {
        return peopleDetailsService.getPersonMovieCredits(id, params)
    }

    fun getPersonTVCredits(id: Int, params: Map<String, String>?): Mono<TvPersonCredits> {
        return peopleDetailsService.getPersonTVCredits(id, params)
    }

    fun getPersonMixedCredits(id: Int, params: Map<String, String>?): Mono<MixedPersonCredits> {
        return peopleDetailsService.getPersonMixedCredits(id, params)
    }

    fun getMovieCredits(id: Int, params: Map<String, String>?): Mono<Credits> {
        return movieDetailsService.getCredits(id, params)
    }

    fun getTVCredits(id: Int, params: Map<String, String>?): Mono<Credits> {
        return tvDetailsService.getCredits(id, params)
    }
}
package com.jaju.kursach_core.data.tmdb.service.details


import com.jaju.kursach_core.data.tmdb.model.ResultResponse
import com.jaju.kursach_core.data.tmdb.model.ResultResponseDates
import com.jaju.kursach_core.data.tmdb.model.fully.Credits
import com.jaju.kursach_core.data.tmdb.model.fully.Images
import com.jaju.kursach_core.data.tmdb.model.fully.Videos
import com.jaju.kursach_core.data.tmdb.model.fully.movie.Movie
import com.jaju.kursach_core.data.tmdb.model.simple.SimpleMovie
import com.jaju.kursach_core.data.tmdb.service.details.MovieDetailsService.MovieEndpoints.*
import com.jaju.kursach_core.web.tmdb.TMDBConfig.Companion.API_KEY
import com.jaju.kursach_core.web.tmdb.TMDBConfig.Companion.BASE_URL
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class MovieDetailsService @Autowired constructor(@Qualifier(value = "webClient") val webclient: WebClient) {
    private val ulr = BASE_URL + "movie/"

    enum class MovieEndpoints(private val endpoint: String) {
        NONE(""),
        IMAGES("/images"),
        VIDEOS("/videos"),
        SIMILAR("/similar"),
        RECOMMENDATIONS("/recommendations"),
        POPULAR("/popular"),
        TOP_RATED("/top_rated"),
        CREDITS("/credits"),
        UPCOMING("/upcoming");

        override fun toString(): String {
            return endpoint
        }
    }

    fun buildUri(id: Int? = null, endpoint: MovieEndpoints, params: Map<String, String>?): String {
        return ulr + "${id
                ?: ""}$endpoint?api_key=$API_KEY${params?.map { entry -> "${entry.key}=${entry.value}" }?.joinToString(prefix = "&", separator = "&")}"
    }

    private inline fun <reified T> sendRequest(id: Int? = null, params: Map<String, String>?, endpoint: MovieEndpoints): Mono<T> {
        return webclient.get().uri(buildUri(id = id, params = params, endpoint = endpoint)).retrieve().bodyToMono(T::class.java)
    }

    fun getMovie(id: Int, params: Map<String, String>?): Mono<Movie> {
        return sendRequest(id, params, NONE)
    }

    fun getMovieImages(id: Int, params: Map<String, String>?): Mono<Images> {
        return sendRequest(id, params, IMAGES)
    }

    fun getMovieVideos(id: Int, params: Map<String, String>?): Mono<Videos> {
        return sendRequest(id, params, VIDEOS)
    }

    fun getSimilarMovies(id: Int, params: Map<String, String>?): Mono<ResultResponse<Movie>> {
        return sendRequest(id, params, SIMILAR)
    }

    fun getRecommendations(id: Int, params: Map<String, String>?): Mono<ResultResponse<Movie>> {
        return sendRequest(id, params, RECOMMENDATIONS)
    }

    fun getCredits(id: Int, params: Map<String, String>?): Mono<Credits> {
        return sendRequest(id, params, CREDITS)
    }

    fun getPopular(params: Map<String, String>?): Mono<ResultResponse<Movie>> {
        return sendRequest(params = params, endpoint = POPULAR)
    }

    fun getTopRated(params: Map<String, String>?): Mono<ResultResponse<Movie>> {
        return sendRequest(params = params, endpoint = TOP_RATED)
    }

    fun getUpComingMovies(params: Map<String, String>?): Mono<ResultResponseDates<SimpleMovie>> {
        return sendRequest(params = params, endpoint = UPCOMING)
    }
}
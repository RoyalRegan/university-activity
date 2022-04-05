package com.jaju.kursach_core.data.tmdb.service.details

import com.jaju.kursach_core.data.tmdb.model.ResultResponse
import com.jaju.kursach_core.data.tmdb.model.fully.Credits
import com.jaju.kursach_core.data.tmdb.model.fully.Images
import com.jaju.kursach_core.data.tmdb.model.fully.Videos
import com.jaju.kursach_core.data.tmdb.service.details.TvDetailsService.TVEndpoints.*
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
class TvDetailsService @Autowired constructor(@Qualifier(value = "webClient") val webclient: WebClient) {
    private val ulr = BASE_URL + "tv/"

    enum class TVEndpoints(private val endpoint: String) {
        NONE(""),
        IMAGES("/images"),
        VIDEOS("/videos"),
        SIMILAR("/similar"),
        RECOMMENDATIONS("/recommendations"),
        POPULAR("/popular"),
        TOP_RATED("/top_rated"),
        CREDITS("/credits"),
        SEASON("/season/");

        override fun toString(): String {
            return endpoint
        }
    }

    fun buildUri(id: Int? = null, endpoint: TVEndpoints, params: Map<String, String>?, seasonNum: Int?): String {
        return ulr +
                "${id ?: ""}$endpoint${seasonNum ?: ""}" +
                "?api_key=${API_KEY}" +
                "${params?.map { entry -> "${entry.key}=${entry.value}" }?.joinToString(prefix = "&", separator = "&")}"
    }

    private inline fun <reified T> sendRequest(id: Int? = null, params: Map<String, String>?, endpoint: TVEndpoints, seasonNum: Int? = null): Mono<T> {
        return webclient.get().uri(buildUri(id = id, params = params, endpoint = endpoint, seasonNum = seasonNum)).retrieve().bodyToMono(T::class.java)
    }

    fun getTV(id: Int, params: Map<String, String>?): Mono<TV> {
        return sendRequest(id, params, NONE)
    }

    fun getTvImages(id: Int, params: Map<String, String>?): Mono<Images> {
        return sendRequest(id, params, IMAGES)
    }

    fun getTvVideos(id: Int, params: Map<String, String>?): Mono<Videos> {
        return sendRequest(id, params, VIDEOS)
    }

    fun getSimilarMovies(id: Int, params: Map<String, String>?): Mono<ResultResponse<TV>> {
        return sendRequest(id, params, SIMILAR)
    }

    fun getRecommendations(id: Int, params: Map<String, String>?): Mono<ResultResponse<TV>> {
        return sendRequest(id, params, RECOMMENDATIONS)
    }

    fun getPopular(params: Map<String, String>?): Mono<ResultResponse<TV>> {
        return sendRequest(params = params, endpoint = POPULAR)
    }

    fun getCredits(id: Int, params: Map<String, String>?): Mono<Credits> {
        return sendRequest(id, params, CREDITS)
    }

    fun getTopRated(params: Map<String, String>?): Mono<ResultResponse<TV>> {
        return sendRequest(params = params, endpoint = TOP_RATED)
    }

    fun getTvSeason(id: Int, params: Map<String, String>?, seasonNum: Int): Mono<TvSeason> {
        return sendRequest(id, params, SEASON, seasonNum)
    }
}
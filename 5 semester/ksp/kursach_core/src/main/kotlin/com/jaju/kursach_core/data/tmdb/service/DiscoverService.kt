package com.jaju.kursach_core.data.tmdb.service

import com.jaju.kursach_core.data.tmdb.model.ResultResponse
import com.jaju.kursach_core.data.tmdb.model.simple.SimpleMovie
import com.jaju.kursach_core.data.tmdb.model.simple.SimpleTV
import com.jaju.kursach_core.data.tmdb.service.DiscoverService.DiscoverObjects.MOVIE
import com.jaju.kursach_core.data.tmdb.service.DiscoverService.DiscoverObjects.TV
import com.jaju.kursach_core.web.tmdb.TMDBConfig.Companion.API_KEY
import com.jaju.kursach_core.web.tmdb.TMDBConfig.Companion.BASE_URL
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class DiscoverService @Autowired constructor(@Qualifier(value = "webClient") val webclient: WebClient) {
    private val url = BASE_URL+"discover/"

    enum class DiscoverObjects {
        MOVIE,
        TV;

        override fun toString(): String {
            return super.toString().toLowerCase()
        }
    }

    fun discoverMovie(params: Map<String, String>): Mono<ResultResponse<SimpleMovie>> {
        return sendRequest(MOVIE, params)
    }

    fun discoverTV(params: Map<String, String>): Mono<ResultResponse<SimpleTV>> {
        return sendRequest(TV, params)
    }

    private fun buildUri(type: DiscoverObjects, params: Map<String, String>): String {
        return url + type + "?api_key=$API_KEY&${params.map { entry -> "${entry.key}=${entry.value}" }.joinToString(separator = "&")}"
    }

    private inline fun <reified T> sendRequest(type: DiscoverObjects, params: Map<String, String>): Mono<T> {
        println(buildUri(type, params))
        return webclient.get().uri(buildUri(type, params)).retrieve().bodyToMono(T::class.java)
    }
}
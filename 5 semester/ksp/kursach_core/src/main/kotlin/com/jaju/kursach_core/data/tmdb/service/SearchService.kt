package com.jaju.kursach_core.data.tmdb.service


import com.jaju.kursach_core.data.tmdb.model.ResultResponse
import com.jaju.kursach_core.data.tmdb.model.simple.AbstractSimpleObject
import com.jaju.kursach_core.data.tmdb.model.simple.SimpleMovie
import com.jaju.kursach_core.data.tmdb.model.simple.SimplePerson
import com.jaju.kursach_core.data.tmdb.model.simple.SimpleTV
import com.jaju.kursach_core.data.tmdb.service.SearchService.SearchObjects.*
import com.jaju.kursach_core.web.tmdb.TMDBConfig.Companion.API_KEY
import com.jaju.kursach_core.web.tmdb.TMDBConfig.Companion.BASE_URL
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class SearchService @Autowired constructor(@Qualifier(value = "webClient") val webclient: WebClient) {
    private val url = BASE_URL + "search/"

    enum class SearchObjects {
        MOVIE,
        TV,
        PERSON,
        MULTI;

        override fun toString(): String {
            return super.toString().toLowerCase()
        }
    }

    fun searchMovie(params: Map<String, String>): Mono<ResultResponse<SimpleMovie>> {
        return sendRequest(MOVIE, params)
    }

    fun searchTV(params: Map<String, String>): Mono<ResultResponse<SimpleTV>> {
        return sendRequest(TV, params)
    }

    fun searchPerson(params: Map<String, String>): Mono<ResultResponse<SimplePerson>> {
        return sendRequest(PERSON, params)
    }

    fun searchMulti(params: Map<String, String>): Mono<ResultResponse<AbstractSimpleObject>> {
        return sendRequest(MULTI, params)
    }

    private fun buildUri(type: SearchObjects, params: Map<String, String>): String {
        return url + type + "?api_key=$API_KEY&${params.map { entry -> "${entry.key}=${entry.value}" }.joinToString(separator = "&")}"
    }

    private inline fun <reified T> sendRequest(type: SearchObjects, params: Map<String, String>): Mono<T> {
        return webclient.get().uri(buildUri(type, params)).retrieve().bodyToMono(T::class.java)
    }
}

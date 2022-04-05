package com.jaju.kursach_core.data.tmdb.service.details

import com.jaju.kursach_core.data.tmdb.model.ResultResponse
import com.jaju.kursach_core.data.tmdb.model.fully.person.*
import com.jaju.kursach_core.data.tmdb.model.simple.SimplePerson
import com.jaju.kursach_core.data.tmdb.service.details.PeopleDetailsService.PersonEndpoints.*
import com.jaju.kursach_core.web.tmdb.TMDBConfig.Companion.API_KEY
import com.jaju.kursach_core.web.tmdb.TMDBConfig.Companion.BASE_URL
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class PeopleDetailsService @Autowired constructor(@Qualifier(value = "webClient") val webclient: WebClient) {
    private val ulr = BASE_URL + "person/"

    enum class PersonEndpoints(private val endpoint: String) {
        NONE(""),
        IMAGES("/images"),
        CREDITS_MOVIE("/movie_credits"),
        CREDITS_TV("/tv_credits"),
        POPULAR("/popular"),
        CREDITS_MIXED("/combined_credits");

        override fun toString(): String {
            return endpoint
        }
    }

    fun buildUri(id: Int? = null, endpoint: PersonEndpoints, params: Map<String, String>?): String {
        return ulr + "${id
                ?: ""}$endpoint?api_key=${API_KEY}${params?.map { entry -> "${entry.key}=${entry.value}" }?.joinToString(prefix = "&", separator = "&")}"
    }

    private inline fun <reified T> sendRequest(id: Int? = null, params: Map<String, String>?, endpoint: PersonEndpoints): Mono<T> {
        return webclient.get().uri(buildUri(id = id, params = params, endpoint = endpoint)).retrieve().bodyToMono(T::class.java)
    }

    fun getPerson(id: Int, params: Map<String, String>?): Mono<Person> {
        return sendRequest(id, params, NONE)
    }

    fun getPopularPerson(params: Map<String, String>?): Mono<ResultResponse<SimplePerson>> {
        return sendRequest(params = params, endpoint = POPULAR)
    }

    fun getPersonImages(id: Int, params: Map<String, String>?): Mono<PersonImages> {
        return sendRequest(id, params, IMAGES)
    }

    fun getPersonMovieCredits(id: Int, params: Map<String, String>?): Mono<MoviePersonCredits> {
        return sendRequest(id, params, CREDITS_MOVIE)
    }

    fun getPersonTVCredits(id: Int, params: Map<String, String>?): Mono<TvPersonCredits> {
        return sendRequest(id, params, CREDITS_TV)
    }

    fun getPersonMixedCredits(id: Int, params: Map<String, String>?): Mono<MixedPersonCredits> {
        return sendRequest(id, params, CREDITS_MIXED)
    }
}
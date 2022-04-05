package com.jaju.kursach_core.web.tmdb

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class TMDBConfig {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API_KEY = "b3815077e98d23728744f795406b0ab2"
    }

    @Bean(name = ["webClient"])
    fun getWebClientBuilder() = WebClient.builder().build()
}
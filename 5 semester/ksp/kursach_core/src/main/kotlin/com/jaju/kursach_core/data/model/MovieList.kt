package com.jaju.kursach_core.data.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.jaju.kursach_core.util.serelizer.ClientSerelizer
import javax.persistence.*

@Entity
@Table
data class MovieList
(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int? = null,
        @ManyToOne
        @JsonProperty("client_login")
        @JsonSerialize(using = ClientSerelizer::class, `as` = Client::class)
        val client: Client,
        var name: String,
        @CollectionTable(name = "movies")
        val movies: LinkedHashSet<UserRate> = LinkedHashSet(),
        @CollectionTable(name = "tags")
        val tags: HashSet<Int> = HashSet(),
        var private: Boolean
)
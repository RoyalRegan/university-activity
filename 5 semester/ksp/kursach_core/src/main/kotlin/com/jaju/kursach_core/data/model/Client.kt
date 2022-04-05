package com.jaju.kursach_core.data.model

import javax.persistence.*

@Entity
@Table
data class Client
(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int? = null,
        @Column
        val name: String,
        @Column(name = "icon_url")
        var iconUrl: String?,
        @Column(name = " background_url")
        var backgroundUrl: String?,
        @Column(unique = true, nullable = false, updatable = false)
        val login: String,
        var password: String,
        @Column(unique = true, nullable = false, updatable = false)
        val email: String
)
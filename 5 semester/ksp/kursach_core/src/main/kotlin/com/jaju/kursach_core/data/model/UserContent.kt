package com.jaju.kursach_core.data.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.jaju.kursach_core.util.serelizer.ClientSerelizer
import javax.persistence.*

@Entity
@Table
data class UserContent(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int? = null,
        @ManyToOne
        @JsonProperty("client_login")
        @JsonSerialize(using = ClientSerelizer::class, `as` = Client::class)
        val client: Client?,
        @Column(name = "image_source")
        val imageSource: ByteArray) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserContent

        if (id != other.id) return false
        if (!imageSource.contentEquals(other.imageSource)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + imageSource.contentHashCode()
        return result
    }
}
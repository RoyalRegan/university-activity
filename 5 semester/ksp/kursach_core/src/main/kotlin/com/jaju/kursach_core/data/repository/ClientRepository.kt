package com.jaju.kursach_core.data.repository

import com.jaju.kursach_core.data.model.Client
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository : CrudRepository<Client, Int> {
    fun findByName(username: String): Client?
}
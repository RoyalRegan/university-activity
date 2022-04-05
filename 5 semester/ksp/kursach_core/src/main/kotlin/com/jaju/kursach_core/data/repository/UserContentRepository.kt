package com.jaju.kursach_core.data.repository

import com.jaju.kursach_core.data.model.UserContent
import org.springframework.data.repository.CrudRepository

interface UserContentRepository : CrudRepository<UserContent, Int> {
}
package com.jaju.kursach_core.data.repository

import com.jaju.kursach_core.data.model.MovieList
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieListRepository : PagingAndSortingRepository<MovieList, Int> {
    //TODO:Tags
    fun findAllByNameLikeIgnoreCaseAndPrivateFalse(name: String, pageable: Pageable): Page<MovieList>

    fun findAllByClientId(clientId: Int): List<MovieList>
}
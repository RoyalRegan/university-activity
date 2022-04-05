package com.jaju.kursach_core.data.repository

import com.jaju.kursach_core.data.model.TVList
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface TVListRepository : PagingAndSortingRepository<TVList, Int> {
    //TODO:Tags
    fun findAllByNameLikeIgnoreCaseAndPrivateFalse(name: String, pageable: Pageable): Page<TVList>

    fun findAllByClientId(clientId: Int): List<TVList>

}
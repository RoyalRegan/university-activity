package com.jaju.kursach_core.data.service

import com.jaju.kursach_core.data.model.UserContent
import com.jaju.kursach_core.data.repository.UserContentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StorageService @Autowired constructor(val userContentRepository: UserContentRepository) {

    fun addData(inputData: UserContent): Int {
        return userContentRepository.save(inputData).id!!
    }

    fun getData(id: Int): UserContent {
        return userContentRepository.findById(id).get()
    }
}

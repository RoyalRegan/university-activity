package com.jaju.kursach_core.web

import com.jaju.kursach_core.data.repository.ClientRepository
import com.jaju.kursach_core.data.service.StorageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RestController
@RequestMapping("/api/storage/")
class StorageController @Autowired constructor(private val clientRepository: ClientRepository,
                                               private val storageService: StorageService) {

    @GetMapping("{id}")
    fun getResource(@PathVariable("id") resourceId: Int): ByteArray {
        return storageService.getData(resourceId).imageSource
    }
}
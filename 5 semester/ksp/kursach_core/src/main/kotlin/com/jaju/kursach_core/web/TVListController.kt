package com.jaju.kursach_core.web

import com.jaju.kursach_core.data.model.TVList
import com.jaju.kursach_core.data.model.UserRate
import com.jaju.kursach_core.data.repository.ClientRepository
import com.jaju.kursach_core.data.service.TVService
import com.jaju.kursach_core.security.CustomUserDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RestController
@RequestMapping("/api/list/tv")
class TVListController @Autowired constructor(private val clientRepository: ClientRepository,
                                              private val tvService: TVService) {
    @GetMapping("{id}")
    fun getTVList(@PathVariable("id") listId: Int,
                  @AuthenticationPrincipal customUserDetails: CustomUserDetails): TVList? {
        return tvService.getList(listId, customUserDetails.id)
    }

    @PostMapping
    fun createTVList(@RequestParam("name") name: String,
                     @RequestParam("private") private: Boolean,
                     @AuthenticationPrincipal customUserDetails: CustomUserDetails) {
        tvService.addList(name, private, clientRepository.findById(customUserDetails.id).orElseThrow())
    }

    @PostMapping("{id}/items")
    fun addTVToList(@PathVariable("id") listId: Int,
                    @RequestBody tvIds: ArrayList<UserRate>,
                    @AuthenticationPrincipal customUserDetails: CustomUserDetails) {
        tvService.addTVToList(listId, tvIds, customUserDetails.id)
    }

    @PostMapping("{id}/tags")
    fun addTVTags(@PathVariable("id") listId: Int,
                  @RequestParam("ids") tags: ArrayList<Int>,
                  @AuthenticationPrincipal customUserDetails: CustomUserDetails) {
        tvService.addTags(listId, tags, customUserDetails.id)
    }

    @DeleteMapping("{id}/tags")
    fun deleteTVTags(@PathVariable("id") listId: Int,
                     @RequestParam("ids") tags: ArrayList<Int>,
                     @AuthenticationPrincipal customUserDetails: CustomUserDetails) {
        tvService.deleteTags(listId, tags, customUserDetails.id)
    }

    @DeleteMapping("{id}/items")
    fun deleteTVFromList(@PathVariable("id") listId: Int,
                         @RequestParam("ids") tvIds: ArrayList<Int>,
                         @AuthenticationPrincipal customUserDetails: CustomUserDetails) {
        tvService.deleteTVFromList(listId, tvIds, customUserDetails.id)
    }

    @DeleteMapping("{id}")
    fun deleteTVList(@PathVariable("id") listId: Int,
                     @AuthenticationPrincipal customUserDetails: CustomUserDetails) {
        tvService.deleteTVList(listId, customUserDetails.id)
    }

    @PutMapping("/{id}")
    fun updatePrivate(@PathVariable("id") listId: Int,
                      @AuthenticationPrincipal customUserDetails: CustomUserDetails,
                      @RequestParam("name") name: String?,
                      @RequestParam("private") private: Boolean?) {
        tvService.updateList(listId, customUserDetails.id, private, name)
    }
}
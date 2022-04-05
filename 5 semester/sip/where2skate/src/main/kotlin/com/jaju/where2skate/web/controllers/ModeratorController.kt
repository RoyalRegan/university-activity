package com.jaju.where2skate.web.controllers

import com.jaju.where2skate.data.dao.user.admin.complain.Request
import com.jaju.where2skate.data.services.ModeratorService
import com.jaju.where2skate.security.CustomUserDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.annotation.Secured
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@CrossOrigin(value = ["*"])
@RestController
@RequestMapping(value = ["api/admin/"])
@Secured(value = ["ROLE_ADMIN"])
class ModeratorController @Autowired constructor(val moderatorService: ModeratorService) {

    @GetMapping(value = ["requests"])
    fun getRequests(): List<Request> {
        return moderatorService.getComplains()
    }

    @PostMapping(value = ["rink/{id}/update"])
    fun releaseRinkUpdate(@AuthenticationPrincipal principal: CustomUserDetails,
                          @PathVariable(value = "id") id: Int) {
        moderatorService.releaseRinkUpdate(id, principal.uuid)
    }

    @PostMapping(value = ["rink/{id}/insert"])
    fun releaseRinkInsert(@AuthenticationPrincipal principal: CustomUserDetails,
                          @PathVariable(value = "id") id: Int) {
        moderatorService.releaseRinkInsert(id, principal.uuid)
    }

    //TODO: fully moder api
}
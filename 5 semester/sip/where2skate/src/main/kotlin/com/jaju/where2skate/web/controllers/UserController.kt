package com.jaju.where2skate.web.controllers

import com.jaju.where2skate.data.dao.rink.RinkComment
import com.jaju.where2skate.data.dao.user.admin.complain.Request
import com.jaju.where2skate.data.services.UserService
import com.jaju.where2skate.data.dao.user.User
import com.jaju.where2skate.data.mappers.rink.RinkCommentMapper
import com.jaju.where2skate.security.CustomUserDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import java.sql.Types

@CrossOrigin(value = ["*"])
@RestController
@RequestMapping(value = ["api/user/"])
class UserController @Autowired constructor(val userService: UserService) {

    @GetMapping(value = ["whoami"])
    fun whoAmI(@AuthenticationPrincipal principal: CustomUserDetails): User {
        return userService.getUserByUuid(uuid = principal.uuid)!!
    }

    @PostMapping(value = ["request"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addRequest(@AuthenticationPrincipal userDetails: CustomUserDetails,
                   @RequestBody request: Request) {
        userService.addRequest(
                request = request,
                uuid = userDetails.uuid
        )
    }

    @GetMapping(value = ["comments"])
    fun getUserComments(@AuthenticationPrincipal userDetails: CustomUserDetails,
                        @RequestParam(value = "limit") limit: Int?,
                        @RequestParam(value = "page") page: Int?):List<RinkComment> {
        return userService.getUserComments(
                uuid = userDetails.uuid,
                page = page?:1,
                limit = limit?:1)

    }
}
package com.jaju.where2skate.web.controllers

import com.jaju.where2skate.data.dao.rink.params.OpenHours
import com.jaju.where2skate.data.dao.rink.params.OptionalParam
import com.jaju.where2skate.data.dao.rink.*
import com.jaju.where2skate.data.services.RinkService
import com.jaju.where2skate.data.dao.user.UserRate
import com.jaju.where2skate.security.CustomUserDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@CrossOrigin(value = ["*"])
@RestController
@RequestMapping(value = ["api/"])
class RinkController @Autowired constructor(private val rinkService: RinkService) {
    @GetMapping(value = ["rinks"])
    fun getRinks(@RequestParam(value = "latitude") latitude: Double,
                 @RequestParam(value = "longitude") longitude: Double,
                 @RequestParam(value = "radius") radius: Double?,
                 @RequestParam(value = "type") type: Array<String>?,
                 @RequestParam(value = "optional") optional: Set<OptionalParam>?,
                 @RequestParam(value = "rating") rating: Double?,
                 @RequestParam(value = "open") open: Set<OpenHours>?): List<RinkSimple> {

        return rinkService.getRinks(
                latitude = latitude,
                longitude = longitude,
                radius = radius ?: 1.0,
                type = type,
                optional = optional,
                rating = rating,
                open = open
        )
    }

    @GetMapping(value = ["rink/{id}"])
    fun getRinkDetail(@PathVariable(value = "id") rinkId: Int): Rink? {
        return rinkService.getRinkDetails(rinkId = rinkId)
    }

    @GetMapping(value = ["rink-types"])
    fun getRinkTypes(): List<RinkType> {
        return rinkService.getRinkTypes()
    }

    @GetMapping(value = ["rink/{id}/photos"])
    fun getRinkPhotos(@PathVariable(value = "id") rinkId: Int): List<RinkPhoto> {
        return rinkService.getRinkPhotos(rinkId = rinkId)
    }

    @GetMapping(value = ["rink/{id}/comments"])
    fun getRinkComments(@PathVariable(value = "id") rinkId: Int,
                        @RequestParam(value = "limit") limit: Int?,
                        @RequestParam(value = "page") page: Int?,
                        @AuthenticationPrincipal principal: CustomUserDetails?): List<RinkComment> {
        return rinkService.getRinkComments(
                rinkId = rinkId,
                limit = limit ?: 1,
                page = page ?: 1,
                uuid = principal?.uuid
        )
    }

    @PostMapping(value = ["/rink"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addRink(@RequestBody rink: Rink,
                @AuthenticationPrincipal principal: CustomUserDetails,
                @RequestParam("force") force:Int?) {
        rinkService.addRink(
                rink = rink,
                uuid = principal.uuid,
                force = force?:0
        )
    }

    @PostMapping(value = ["/comment"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addRinkComment(@RequestBody comment: RinkComment,
                       @AuthenticationPrincipal principal: CustomUserDetails) {
        rinkService.addComment(
                rinkComment = comment,
                uuid = principal.uuid
        )
    }

    @PostMapping(value = ["/rink/comment/user_rate"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addUserRate(@RequestBody userRate: UserRate,
                    @AuthenticationPrincipal principal: CustomUserDetails) {
        rinkService.addUserRate(
                userRate = userRate,
                uuid = principal.uuid
        )
    }

    @PutMapping(value = ["/rink/{id}"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateRink(@RequestBody rink: Rink,
                   @AuthenticationPrincipal principal: CustomUserDetails,
                   @PathVariable("id") id: Int,
                   @RequestParam("force") force:Int?) {
        rinkService.updateRink(
                rink = rink,
                uuid = principal.uuid,
                v_parent_rink_id = id,
                force = force?:0
        )
    }

    @PutMapping(value = ["/comment/{id}"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateComment(@RequestBody comment: RinkComment,
                      @AuthenticationPrincipal principal: CustomUserDetails,
                      @PathVariable("id") id: Int) {
        rinkService.updateComment(
                rinkComment = comment,
                uuid = principal.uuid,
                id = id)
    }
}
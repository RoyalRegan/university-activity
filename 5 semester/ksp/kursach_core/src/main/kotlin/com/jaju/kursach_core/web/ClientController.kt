package com.jaju.kursach_core.web

import com.jaju.kursach_core.data.model.Client
import com.jaju.kursach_core.data.model.MovieList
import com.jaju.kursach_core.data.model.TVList
import com.jaju.kursach_core.data.service.ClientService
import com.jaju.kursach_core.data.service.MovieService
import com.jaju.kursach_core.data.service.TVService
import com.jaju.kursach_core.security.CustomUserDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RestController
@RequestMapping("/api/")
class ClientController @Autowired constructor(private val clientService: ClientService,
                                              private val movieService: MovieService,
                                              private val tvService: TVService) {

    @PostMapping("registration")
    fun registration(@RequestBody client: Client) {
        clientService.registerClient(client)
    }

    @GetMapping("client/whoami")
    fun whoami(@AuthenticationPrincipal customUserDetails: CustomUserDetails): Client {
        return clientService.whoami(customUserDetails.id)
    }

    @GetMapping("client/lists/tv")
    fun getClientTVLists(@AuthenticationPrincipal customUserDetails: CustomUserDetails): List<TVList> {
        return tvService.getClientList(customUserDetails.id)
    }

    @GetMapping("client/lists/movie")
    fun getClientMovieLists(@AuthenticationPrincipal customUserDetails: CustomUserDetails): List<MovieList> {
        return movieService.getClientList(customUserDetails.id)
    }

    @PutMapping("client/password")
    fun updateClientPassword(@AuthenticationPrincipal customUserDetails: CustomUserDetails,
                             @RequestBody body: Map<String, String>) {
        clientService.changePassword(customUserDetails.id, body.getValue("password"))
    }

    @PutMapping("client/icon")
    fun updateClientIcon(@AuthenticationPrincipal customUserDetails: CustomUserDetails,
                         @RequestBody body: Map<String, ByteArray>) {
        clientService.changeIcon(customUserDetails.id, body.getValue("icon"))
    }

    @PutMapping("client/background")
    fun updateClientBackground(@AuthenticationPrincipal customUserDetails: CustomUserDetails,
                               @RequestBody body: Map<String, ByteArray>) {
        clientService.changeBackground(customUserDetails.id, body.getValue("background"))
    }
}
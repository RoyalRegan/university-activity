package com.jaju.kursach_core.data.service

import com.jaju.kursach_core.data.model.Client
import com.jaju.kursach_core.data.model.MovieList
import com.jaju.kursach_core.data.model.TVList
import com.jaju.kursach_core.data.model.UserContent
import com.jaju.kursach_core.data.repository.ClientRepository
import com.jaju.kursach_core.data.repository.MovieListRepository
import com.jaju.kursach_core.data.repository.TVListRepository
import com.jaju.kursach_core.security.DuplicateLoginException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.UniqueConstraint

@Service
class ClientService @Autowired constructor(val clientRepository: ClientRepository,
                                           val movieListRepository: MovieListRepository,
                                           val tvListRepository: TVListRepository,
                                           val bCryptPasswordEncoder: BCryptPasswordEncoder,
                                           val storageService: StorageService) {

    @Transactional
    fun registerClient(client: Client) {
        if (clientRepository.findByName(client.login)==null) {
            client.password = bCryptPasswordEncoder.encode(client.password)

            clientRepository.save(client)

            val defaultMovieList = listOf(MovieList(client = client, name = "Избранное", private = true),
                    MovieList(client = client, name = "Хочу посмотреть", private = true),
                    (MovieList(client = client, name = "Просмотренное", private = false)))

            val defaultTVList = listOf(TVList(client = client, name = "Избранное", private = true),
                    TVList(client = client, name = "Хочу посмотреть", private = true),
                    (TVList(client = client, name = "Просмотренное", private = false)))

            movieListRepository.saveAll(defaultMovieList)
            tvListRepository.saveAll(defaultTVList)
        } else {
            throw DuplicateLoginException()
        }
    }

    fun changePassword(clientId: Int, newPassword: String) {
        val client = clientRepository.findById(clientId).get()
        client.password = bCryptPasswordEncoder.encode(newPassword)
        clientRepository.save(client)
    }

    fun changeIcon(clientId: Int, newIcon: ByteArray) {
        val client = clientRepository.findById(clientId).get()
        //remove previos
        client.iconUrl = "/" + storageService.addData(UserContent(client = client, imageSource = newIcon))
        clientRepository.save(client)
    }

    fun changeBackground(clientId: Int, newBackground: ByteArray) {
        val client = clientRepository.findById(clientId).get()
        //remove previos
        client.backgroundUrl = "/" + storageService.addData(UserContent(client = client, imageSource = newBackground))
        clientRepository.save(client)
    }

    fun whoami(clientId: Int): Client {
        return clientRepository.findById(clientId).get()
    }
}
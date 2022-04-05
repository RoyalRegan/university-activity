package com.jaju.kursach_core.data.service

import com.jaju.kursach_core.data.model.Client
import com.jaju.kursach_core.data.model.MovieList
import com.jaju.kursach_core.data.model.UserRate
import com.jaju.kursach_core.data.repository.MovieListRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class MovieService @Autowired constructor(val movieListRepository: MovieListRepository) {

    fun getList(listId: Int,
                clientId: Int?): MovieList? {
        val list = movieListRepository.findById(listId).orElse(null) ?: null
        if (list != null) {
            if (!list.private) {
                return list
            }
            if (list.private && list.client.id == clientId) {
                return list
            }
        }
        return null
    }

    fun addList(listName: String,
                private: Boolean?,
                client: Client) {
        movieListRepository.save(MovieList(client = client, name = listName, private = private ?: true))
    }

    fun addMovieToList(listId: Int, movieIds: ArrayList<UserRate>, clientId: Int) {
        val list = movieListRepository.findById(listId).orElseThrow()
        if (list.client.id == clientId) {
            list.movies.addAll(movieIds)
            movieListRepository.save(list)
        }
    }

    fun addTags(listId: Int, tags: ArrayList<Int>, clientId: Int) {
        val list = movieListRepository.findById(listId).orElseThrow()
        if (list.client.id == clientId) {
            list.tags.addAll(tags)
            movieListRepository.save(list)
        }
    }

    fun deleteTags(listId: Int, tags: ArrayList<Int>, clientId: Int) {
        val list = movieListRepository.findById(listId).orElseThrow()
        if (list.client.id == clientId) {
            list.tags.removeAll(tags)
            movieListRepository.save(list)
        }
    }

    fun deleteMovieFromList(listId: Int, movieIds: ArrayList<Int>, clientId: Int) {
        val list = movieListRepository.findById(listId).orElseThrow()
        if (list.client.id == clientId) {
            list.movies.removeIf { userRate: UserRate -> movieIds.contains(userRate.objectId) }
            movieListRepository.save(list)
        }
    }

    fun deleteMovieList(listId: Int, clientId: Int) {
        val list = movieListRepository.findById(listId).orElseThrow()
        if (list.client.id == clientId) {
            movieListRepository.deleteById(listId)
        }
    }

    fun findList(query: String?, tags: LinkedHashSet<Int>?, page: Int?, limit: Int?): Page<MovieList> {
        return movieListRepository.findAllByNameLikeIgnoreCaseAndPrivateFalse("%${query ?: ""}%", PageRequest.of(page
                ?: 0, limit
                ?: 5))

    }

    fun getClientList(clientId: Int): List<MovieList> {
        return movieListRepository.findAllByClientId(clientId)
    }

    fun updateList(listId: Int, clientId: Int, private: Boolean?, name: String?) {
        val list = movieListRepository.findById(listId).orElseThrow()
        if (list.client.id == clientId) {
            list.private = private ?: list.private
            list.name = name ?: list.name
            movieListRepository.save(list)
        }
    }
}
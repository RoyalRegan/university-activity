package com.jaju.kursach_core.data.service

import com.jaju.kursach_core.data.model.Client
import com.jaju.kursach_core.data.model.TVList
import com.jaju.kursach_core.data.model.UserRate
import com.jaju.kursach_core.data.repository.TVListRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class TVService @Autowired constructor(val tvListRepository: TVListRepository) {

    fun getList(listId: Int, clientId: Int?): TVList? {
        val list = tvListRepository.findById(listId).orElse(null) ?: null
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
                private: Boolean,
                client: Client) {
        tvListRepository.save(TVList(client = client, name = listName, private = private))
    }

    fun addTVToList(listId: Int, movieIds: ArrayList<UserRate>, clientId: Int) {
        val list = tvListRepository.findById(listId).orElseThrow()
        if (list.client.id == clientId) {
            list.tvs.addAll(movieIds)
            tvListRepository.save(list)
        }
    }


    fun addTags(listId: Int, tags: ArrayList<Int>, clientId: Int) {
        val list = tvListRepository.findById(listId).orElseThrow()
        if (list.client.id == clientId) {
            list.tags.addAll(tags)
            tvListRepository.save(list)
        }
    }

    fun deleteTags(listId: Int, tags: ArrayList<Int>, clientId: Int) {
        val list = tvListRepository.findById(listId).orElseThrow()
        if (list.client.id == clientId) {
            list.tags.removeAll(tags)
            tvListRepository.save(list)
        }
    }

    fun deleteTVFromList(listId: Int, tvIds: ArrayList<Int>, clientId: Int) {
        val list = tvListRepository.findById(listId).orElseThrow()
        if (list.client.id == clientId) {
            list.tvs.removeIf { userRate: UserRate -> tvIds.contains(userRate.objectId) }
            tvListRepository.save(list)
        }
    }

    fun deleteTVList(listId: Int, clientId: Int) {
        val list = tvListRepository.findById(listId).orElseThrow()
        if (list.client.id == clientId) {
            tvListRepository.deleteById(listId)
        }
    }

    fun findList(query: String?, tags: LinkedHashSet<Int>?, page: Int?, limit: Int?): Page<TVList> {
        return tvListRepository.findAllByNameLikeIgnoreCaseAndPrivateFalse("%${query ?: ""}%", PageRequest.of(page
                ?: 0, limit
                ?: 5))

    }

    fun getClientList(clientId: Int): List<TVList> {
        return tvListRepository.findAllByClientId(clientId)
    }

    fun updateList(listId: Int, clientId: Int, private: Boolean?, name: String?) {
        val list = tvListRepository.findById(listId).orElseThrow()
        if (list.client.id == clientId) {
            list.private = private ?: list.private
            list.name = name ?: list.name
            tvListRepository.save(list)
        }
    }
}
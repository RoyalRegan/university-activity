package com.jaju.kursach_core.security

import com.jaju.kursach_core.data.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService @Autowired constructor(val clientRepository: ClientRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val client = clientRepository.findByName(username)
                ?: throw UsernameNotFoundException("user with login $username not found")
        return CustomUserDetails(client.id!!, client.name, client.password, arrayListOf(SimpleGrantedAuthority("USER")))
    }
}
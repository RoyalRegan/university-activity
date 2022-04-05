package com.jaju.where2skate.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails(private val username: String,
                        val uuid: String,
                        private val authorities: MutableCollection<out GrantedAuthority>) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = authorities

    override fun isEnabled(): Boolean = true

    override fun getUsername(): String = username

    override fun isCredentialsNonExpired(): Boolean = false

    override fun getPassword(): String? = null

    override fun isAccountNonExpired(): Boolean = false

    override fun isAccountNonLocked(): Boolean = false
}
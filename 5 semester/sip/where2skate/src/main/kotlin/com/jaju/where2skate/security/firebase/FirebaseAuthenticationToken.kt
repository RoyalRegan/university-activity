package com.jaju.where2skate.security.firebase

import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.GrantedAuthority

class FirebaseAuthenticationToken constructor(private val principal: Any,
                                              private val credentials: Any?,
                                              authorities: Collection<GrantedAuthority>) : AbstractAuthenticationToken(authorities) {

    init {
        isAuthenticated = true
    }

    override fun getCredentials(): Any? = credentials

    override fun getPrincipal(): Any = principal
}
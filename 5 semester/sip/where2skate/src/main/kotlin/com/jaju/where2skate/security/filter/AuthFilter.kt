package com.jaju.where2skate.security.filter

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.jaju.where2skate.security.firebase.FirebaseAuthenticationToken
import com.jaju.where2skate.security.firebase.FirebaseUserDetailsService
import com.jaju.where2skate.util.extension.notNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class AuthFilter @Autowired constructor(private val firebaseUserDetailsService: FirebaseUserDetailsService, @Lazy val firebaseAuth: FirebaseAuth) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val authHead = request.getHeader("Authorization")
        authHead.notNull {
            if (it.startsWith("Bearer ")) {
                val token = it.substring(7)
                val parsedToken = try {
                    firebaseAuth.verifyIdToken(token)
                } catch (e: FirebaseAuthException) {
                    return@notNull
                }
                val userDetails = firebaseUserDetailsService.loadUserByUsername(parsedToken.uid)
                SecurityContextHolder.getContext().authentication = FirebaseAuthenticationToken(userDetails, null, userDetails.authorities)
            }
        }
        filterChain.doFilter(request, response)
    }
}
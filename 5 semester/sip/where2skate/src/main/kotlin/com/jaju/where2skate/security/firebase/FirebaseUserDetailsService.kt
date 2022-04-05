package com.jaju.where2skate.security.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserRecord
import com.jaju.where2skate.data.dao.user.User
import com.jaju.where2skate.data.services.UserService
import com.jaju.where2skate.security.CustomUserDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class FirebaseUserDetailsService @Autowired constructor(private val userService: UserService,
                                                        @Lazy val firebaseAuth: FirebaseAuth) : UserDetailsService {

    private fun storeUser(userRecord: UserRecord): User {
        return userService.addUser(userRecord) ?: throw UsernameNotFoundException("")
    }

    override fun loadUserByUsername(uuid: String): CustomUserDetails {
        val user: User = userService.getUserByUuid(uuid) ?: storeUser(firebaseAuth.getUser(uuid))
        return CustomUserDetails(user.nickname, user.uuid, getAuthorities(user))
    }

    private fun getAuthorities(user:User): MutableCollection<GrantedAuthority> {
        return if (user.moderator == 0) Collections.singleton(SimpleGrantedAuthority("ROLE_USER")) else Collections.singletonList(SimpleGrantedAuthority("ROLE_ADMIN"))
    }
}
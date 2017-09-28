package com.rozkmin.microservice.auth

import com.rozkmin.microservice.domain.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component
interface TokenHandler {

    fun parseUserFromToken(token: String): UserDetails
    fun createTokenForUser(user: User): String

}

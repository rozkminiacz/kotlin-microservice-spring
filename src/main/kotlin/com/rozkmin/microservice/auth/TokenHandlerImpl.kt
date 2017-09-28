package com.rozkmin.microservice.auth

import com.rozkmin.microservice.domain.User
import com.rozkmin.microservice.domain.UserDetailsImpl
import com.rozkmin.microservice.repository.UserRepository
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.time.ZonedDateTime
import java.util.*

@Component
class TokenHandlerImpl(
    @param:Value("secret")
    private val secret: String,
    private val userRepository: UserRepository
) : TokenHandler {

    override fun parseUserFromToken(token: String): UserDetails {
        val userId = Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJws(token)
            .body
            .subject
            .toLong()

        return userRepository.findOne(userId).let(::UserDetailsImpl)
    }

    override fun createTokenForUser(user: User): String {
        val afterOneWeek = ZonedDateTime.now().plusWeeks(1)

        return Jwts.builder()
            .setSubject(user.id.toString())
            .signWith(SignatureAlgorithm.HS512, secret)
            .setExpiration(Date.from(afterOneWeek.toInstant()))
            .compact()
    }

}


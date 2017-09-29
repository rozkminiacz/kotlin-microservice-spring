package com.rozkmin.microservice.service

import com.rozkmin.microservice.auth.SecurityContextService
import com.rozkmin.microservice.domain.User
import com.rozkmin.microservice.dto.request.UserEditParams
import com.rozkmin.microservice.dto.request.UserNewParams
import com.rozkmin.microservice.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserServiceImpl(
        private val userRepository: UserRepository,
        override val securityContextService: SecurityContextService
) : UserService, WithCurrentUser {

    override fun findOne(id: String): User {
        val currentUser = currentUser()
        val user = userRepository.findOne(id)
        val isMyself = currentUser?.let { it.id == user.id }

        user.isMyself=isMyself

        return user
    }

    override fun findMe(): User {
        val currentUser = currentUserOrThrow()
        return findOne(currentUser.id)
    }

    override fun findAll(page: Int, size: Int): MutableIterable<User> =
        userRepository.findAll()

    @Throws(EmailInUseException::class)
    override fun create(params: UserNewParams): User {
        return userRepository.save(User(
                username = params.email,
                password = encrypt(params.password),
                name = params.name
        ))
    }

    override fun updateMe(params: UserEditParams) {
        val currentUser = currentUserOrThrow()
        userRepository.save(currentUser.copy(
            username = params.email ?: currentUser.username,
            password = params.password?.let { encrypt(it) } ?: currentUser.password,
            name = params.name ?: currentUser.name
        ))
    }

    private fun encrypt(secret: String) = BCryptPasswordEncoder().encode(secret)
}

class EmailInUseException : Exception() {

}

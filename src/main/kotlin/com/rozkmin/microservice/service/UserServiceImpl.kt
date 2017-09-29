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

        user.isMyself = isMyself

        return user
    }

    override fun findByName(name: String): MutableIterable<User> = userRepository
            .findByUsername(name)

    override fun findByPhrase(phrase: String) = userRepository.findByUsernameContaining(phrase)

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

    override fun updateMe(params: UserEditParams): User? {
        val currentUser = currentUserOrThrow()
        currentUser.let {
            it.username = params.email ?: it.username;
            it.password = params.password?.let { encrypt(it) } ?: it.password;
            it.name = params.name ?: it.name;
            it.avatar = params.avatar ?: it.avatar
        }

        return userRepository.save(currentUser)

    }

    private fun encrypt(secret: String) = BCryptPasswordEncoder().encode(secret)
}

class EmailInUseException : Exception() {

}

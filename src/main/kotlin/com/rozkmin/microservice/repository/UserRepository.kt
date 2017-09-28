package com.rozkmin.microservice.repository

import com.rozkmin.microservice.domain.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {
    fun findOneByUsername(username: String): User
}
package com.rozkmin.microservice.repository

import com.rozkmin.microservice.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

//@Repository
interface UserRepository : CrudRepository<User, String> {
    fun findOneByUsername(username: String): User
    fun findByUsername(name: String): MutableIterable<User>
    fun findByUsernameContaining(phrase: String): MutableIterable<User>
}
package com.rozkmin.microservice.service

import com.rozkmin.microservice.domain.User
import com.rozkmin.microservice.dto.request.UserEditParams
import com.rozkmin.microservice.dto.request.UserNewParams

interface UserService {
    fun findAll(page: Int, size: Int = 20): MutableIterable<User>
    fun findByName(name: String) : MutableIterable<User>
    fun findByPhrase(phrase : String) : MutableIterable<User>
    fun findOne(id: String): User
    fun findMe(): User
    fun create(params: UserNewParams): User
    fun updateMe(params: UserEditParams) : User?
}
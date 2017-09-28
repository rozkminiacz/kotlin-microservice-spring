package com.rozkmin.microservice.auth

import com.rozkmin.microservice.domain.User

interface SecurityContextService {
    fun currentUser(): User?
}

package com.rozkmin.microservice.service

import com.rozkmin.microservice.auth.SecurityContextService
import com.rozkmin.microservice.domain.User
import org.springframework.security.access.AccessDeniedException

interface WithCurrentUser {

    val securityContextService: SecurityContextService

    fun currentUser(): User? =
        securityContextService.currentUser()

    fun currentUserOrThrow(): User =
        securityContextService.currentUser() ?: throw AccessDeniedException("")
}
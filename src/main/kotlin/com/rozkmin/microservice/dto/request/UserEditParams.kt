package com.rozkmin.microservice.dto.request

import javax.validation.constraints.Size

data class UserEditParams(

        val email: String? = null,

        @get:Size(min = 8, max = 10)
        val password: String? = null,

        val name: String? = null,

        val avatar: String? = null


)

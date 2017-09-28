package com.rozkmin.microservice.dto.request

data class PageParams(
    val sinceId: Long? = null,
    val maxId: Long? = null,
    val count: Int = 20
)
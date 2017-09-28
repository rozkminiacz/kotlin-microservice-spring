package com.rozkmin.microservice.dto.page

data class PageImpl<out T>(
    override val content: List<T>,
    override val totalPages: Int
) : Page<T>
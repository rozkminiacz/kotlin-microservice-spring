package com.rozkmin.microservice.dto.page

interface Page<out T> {
    val totalPages: Int
    val content: List<T>
}
package com.rozkmin.microservice.domain

import javax.persistence.Id

data class Restaurant(
        @Id
        val id: String,
        val name: String,
        val description: String,
        val image: String,
        val address: Double,
        val lat: Double,
        val lon: Double,
        var owner: Long?)
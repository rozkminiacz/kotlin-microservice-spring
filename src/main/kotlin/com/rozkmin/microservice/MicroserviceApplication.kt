package com.rozkmin.microservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class MicroserviceApplication

fun main(args: Array<String>) {
    SpringApplication.run(MicroserviceApplication::class.java, *args)
}

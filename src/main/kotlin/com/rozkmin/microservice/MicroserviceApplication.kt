package com.rozkmin.microservice

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@EnableEncryptableProperties

class MicroserviceApplication

fun main(args: Array<String>) {
    SpringApplication.run(MicroserviceApplication::class.java, *args)
}

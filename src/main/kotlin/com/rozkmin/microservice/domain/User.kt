package com.rozkmin.microservice.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Entity
class User(username: String, password: String, name: String) {
    @Id
    var id: Long = 0
    fun copy(username: String, password: String, name: String): User = User(username, password, name)


    // ------- DB fields -------

    @get:JsonIgnore
    @get:Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")
    @get:Size(min = 4, max = 30)
    var username: String = ""

    @get:JsonIgnore
    val password: String = ""

    @get:Size(min = 4, max = 30)
    val name: String = ""

    // ------- Others -------

    @get:JsonIgnore
    var isMyself: Boolean? = null // null means unknown

}
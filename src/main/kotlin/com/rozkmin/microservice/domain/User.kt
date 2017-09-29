package com.rozkmin.microservice.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.GenericGenerator
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Entity
class User {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    var id: String = ""

    constructor(username: String, password: String, name: String){
        this.username=username
        this.password=password
        this.name=name
    }

    constructor()

    @get:JsonIgnore
    @get:Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")
    @get:Size(min = 4, max = 30)
    @Column(unique = true)
    var username: String = ""

    @get:JsonIgnore
    var password: String = ""

    @get:Size(min = 4, max = 30)
    var name: String = ""

    var avatar: String = ""

    @get:JsonIgnore
    var isMyself: Boolean? = null // null means unknown

}
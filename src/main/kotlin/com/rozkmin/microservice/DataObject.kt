package com.rozkmin.microservice

/**
 * Created by michalik on 20.08.17
 */
class DataObject {
    lateinit var id: String
    var name: String = ""

    constructor(name: String) {
        this.name = name
    }

    constructor()
}
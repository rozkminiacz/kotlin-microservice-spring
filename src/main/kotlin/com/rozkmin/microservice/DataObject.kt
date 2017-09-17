package com.rozkmin.microservice

import javax.persistence.Entity
import javax.persistence.Id

/**
 * Created by michalik on 20.08.17
 */
@Entity
class DataObject {
    @Id
    var id: String = ""
    var name: String = ""
}
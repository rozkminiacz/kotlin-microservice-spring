package com.rozkmin.microservice.dto.request

import javax.validation.constraints.Size

class UserNewParams() {
    var email: String = ""
//    @get:Size(min = 8, max = 10)
    var password: String = ""
    var name: String = ""
}



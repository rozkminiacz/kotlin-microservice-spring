package com.rozkmin.microservice.controller

import com.rozkmin.microservice.domain.User
import com.rozkmin.microservice.dto.request.UserEditParams
import com.rozkmin.microservice.dto.request.UserNewParams
import com.rozkmin.microservice.dto.response.ErrorResponse
import com.rozkmin.microservice.repository.exception.EmailDuplicatedException
import com.rozkmin.microservice.repository.exception.RecordNotFoundException
import com.rozkmin.microservice.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


//@RestController
//@RequestMapping("/api")
//class UserController(
//        private val userService: UserService
//) {
//
//    @GetMapping(path = arrayOf("/users"))
//    fun list(
//            @RequestParam(value = "page", required = false) page: Int?,
//            @RequestParam(value = "size", required = false) size: Int?
//    ) = userService.findAll(
//            page = page ?: 1,
//            size = size ?: 5
//    )
//
////    @GetMapping(path = arrayOf("/users/{phrase:\\s+}"))
////    fun matchingName(@PathVariable("phrase") phrase : String) = userService.findByPhrase(phrase)
//
//    @PostMapping(path = arrayOf("/register"))
//    fun create(@Valid @RequestBody params: UserNewParams): User {
//        return userService.create(params)
//    }
//
//    @GetMapping(path = arrayOf("/users/{id:\\d+}"))
//    fun show(@PathVariable("id") id: String) = userService.findOne(id)
//
//    @GetMapping(path = arrayOf("/me"))
//    fun showMe() = userService.findMe()
//
//    @PatchMapping(path = arrayOf("/me"))
//    fun updateMe(@Valid @RequestBody params: UserEditParams) = userService.updateMe(params)
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(EmailDuplicatedException::class)
//    fun handleEmailDuplicatedException(e: EmailDuplicatedException): ErrorResponse {
//        return ErrorResponse("email_already_taken", "This email is already taken.")
//    }
//
//    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No user")
//    @ExceptionHandler(RecordNotFoundException::class)
//    fun handleUserNotFound() {
//    }
//
//}


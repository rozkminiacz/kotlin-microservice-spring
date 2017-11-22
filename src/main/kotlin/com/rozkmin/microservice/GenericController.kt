package com.rozkmin.microservice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

/**
 * Created by michalik on 20.08.17
 */

@RestController
@RequestMapping("/generic")
class GenericController {

    @Autowired
    lateinit var repository: GenericRepository

    @GetMapping
    fun getDataObjects() = repository.findAll()

    @PostMapping
    fun createDataObject(@RequestBody dataObject: DataObject) = repository.save(dataObject)

}


data class Customer(
        val id: String = "",
        val firstName: String = "",
        val lastName: String = "",
        val email: String = "",
        val phone: String = "",
        val avatar: String = "")

val mockUsers = listOf<Customer>(
        Customer(UUID.randomUUID().toString(), "John", "Messershmidt", "john@internet.com", "+48 699 944 729", "https://randomuser.me/api/portraits/men/${(Random().nextInt() % 99) * -1}.jpg"),
        Customer(UUID.randomUUID().toString(), "Jane", "Werberg", "werber@internet.com", "+48 402 423 555", "https://randomuser.me/api/portraits/women/${(Random().nextInt() % 99) * -1}.jpg"),
        Customer(UUID.randomUUID().toString(), "Erwin", "Schrodinger", "erwin@internet.com", "+48 222 333 444", "https://randomuser.me/api/portraits/men/${(Random().nextInt() % 99) * -1}.jpg"),
        Customer(UUID.randomUUID().toString(), "Max", "Plank", "max@internet.com", "+48 527 423 107", "https://randomuser.me/api/portraits/men/${(Random().nextInt() % 99) * -1}.jpg"),
        Customer(UUID.randomUUID().toString(), "Marie", "Curie", "marie@internet.com", "+48 534 253 037", "https://randomuser.me/api/portraits/women/${(Random().nextInt() % 99) * -1}.jpg")
)

@RestController
@RequestMapping("/api")
class CustomerController {
    @GetMapping
    fun getAll(): List<Customer> {
        return mockUsers
    }
}



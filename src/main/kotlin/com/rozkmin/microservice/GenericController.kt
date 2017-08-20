package com.rozkmin.microservice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Created by michalik on 20.08.17
 */

@RestController
@RequestMapping("/generic")
class GenericController {

    @Autowired
    lateinit var repository: GenericRepository;

    @GetMapping
    fun getDataObjects() = repository.findAll()

    @GetMapping("/{id}")
    fun getDataObject(@PathVariable("id") id: String) = repository.findOne(id)

    @PostMapping
    fun createDataObject(@RequestBody dataObject: DataObject) = repository.save(dataObject)

}



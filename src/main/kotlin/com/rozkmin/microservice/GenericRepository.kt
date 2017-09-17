package com.rozkmin.microservice

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


/**
 * Created by michalik on 20.08.17
 */
@Repository
interface GenericRepository : CrudRepository<DataObject, String>
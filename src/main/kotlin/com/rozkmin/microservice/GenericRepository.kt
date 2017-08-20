package com.rozkmin.microservice

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

/**
 * Created by michalik on 20.08.17
 */
@Repository
interface GenericRepository : MongoRepository<DataObject, String>
package com.rozkmin.microservice.repository.exception

import org.springframework.dao.DuplicateKeyException

class RelationshipDuplicatedException(msg: String) : DuplicateKeyException(msg)

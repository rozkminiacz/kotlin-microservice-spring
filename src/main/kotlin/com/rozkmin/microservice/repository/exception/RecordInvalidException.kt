package com.rozkmin.microservice.repository.exception

import org.springframework.dao.DataIntegrityViolationException

class RecordInvalidException(msg: String) : DataIntegrityViolationException(msg)
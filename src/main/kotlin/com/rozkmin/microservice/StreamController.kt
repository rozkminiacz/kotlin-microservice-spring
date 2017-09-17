package com.rozkmin.microservice

import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.*

/**
 * Created by michalik on 21.08.17
 */
@RestController

@RequestMapping("/stream")
class StreamController {
    val emmiters: ArrayList<SseEmitter> = arrayListOf<SseEmitter>()


    @GetMapping
    fun subscribeToStream(): SseEmitter {
        var element = SseEmitter()
        emmiters.add(element)

        element.onCompletion({ this.emmiters.remove(element) })
        element.onTimeout({ this.emmiters.remove(element) })

        return element
    }


    @PostMapping
    fun notifyAll(@RequestBody streamData: StreamData): StreamData {
        println(streamData)
        emmiters.forEach({
            try {
                it.send(streamData)
            } catch (e: Exception) {
                println(e)
                emmiters.remove(it)
            }
        })
        return streamData
    }

}

data class StreamData(val id : String = UUID.randomUUID().toString(), val content : Map<String, Any> = mapOf())

package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class HateoasSlashExampleApplication

fun main(args: Array<String>) {
    runApplication<HateoasSlashExampleApplication>(*args)
}

@RestController
class TestController {

    @GetMapping("hello")
    fun testMethod(): ResponseEntity<String> {
        val controller = WebMvcLinkBuilder.methodOn(TestController::class.java)
        val link = WebMvcLinkBuilder.linkTo(controller.testMethod()).toUri().toString()
        return ResponseEntity.ok(link)
    }
}

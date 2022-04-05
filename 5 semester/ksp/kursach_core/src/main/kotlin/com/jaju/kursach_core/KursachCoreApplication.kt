package com.jaju.kursach_core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KursachCoreApplication

fun main(args: Array<String>) {

    runApplication<KursachCoreApplication>(*args)
}

//TODO: universal build uri and request method
//TODO: catch exceptions from all sendRequest
//TODO: replace MapParams with typed params
//TODO: list search by tags, names, user
//TODO: email verification
//TODO: BIG refactor
package com.ics.micmaestro

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MaestroApplication

fun main(args: Array<String>) {
    runApplication<MaestroApplication>(*args)
}

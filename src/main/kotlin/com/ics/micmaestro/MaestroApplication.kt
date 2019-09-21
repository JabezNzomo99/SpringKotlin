package com.ics.micmaestro

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients


@SpringBootApplication
@EnableFeignClients
class MaestroApplication

fun main(args: Array<String>) {
    runApplication<MaestroApplication>(*args)

}

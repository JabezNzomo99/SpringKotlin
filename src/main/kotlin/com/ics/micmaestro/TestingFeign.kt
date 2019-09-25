package com.ics.micmaestro

import com.ics.micmaestro.feign.FeignRestClient
import com.ics.micmaestro.models.Actor
import com.ics.micmaestro.models.Movie
import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
import feign.okhttp.OkHttpClient
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component


class TestingFeign(private val feignRestClient:FeignRestClient):CommandLineRunner {

    override fun run(vararg args: String?) {
        val actors = listOf<Actor>()
        val testMovie = Movie(name = "Can you keep a Secret?",yearReleased = "2019",actors = actors)
        val createdMovie = feignRestClient.createMovie(testMovie)
        println("New movie created: $createdMovie")

        val allMovies = feignRestClient.getAllMovies()
        allMovies.printCollection()

        createdMovie.name = "Divergent"
        val updatedMovie = feignRestClient.updateMovie(createdMovie.id!!,createdMovie)
        println("Movie Updated: $updatedMovie")


    }
}
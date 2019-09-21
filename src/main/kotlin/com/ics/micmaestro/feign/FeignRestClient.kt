package com.ics.micmaestro.feign

import com.ics.micmaestro.models.Movie
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = "micmaestro", url="http://localhost:8080")
interface FeignRestClient {

    @RequestMapping(method = [RequestMethod.GET], value = ["movies"])
    fun getAllMovies():List<Movie>

    @RequestMapping(method = [RequestMethod.GET], value = ["movies/{id}"])
    fun findMovieById(@PathVariable(name = "id") id:Long):Movie

    @RequestMapping(method = [RequestMethod.POST], value = ["movies"])
    fun createMovie(@RequestBody movie: Movie):Movie

    @RequestMapping(method = [RequestMethod.PATCH], value = ["movies/{id}"])
    fun updateMovie(@PathVariable(name = "id") id:Long, @RequestBody movie:Movie):Movie

}
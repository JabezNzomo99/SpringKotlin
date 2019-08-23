package com.ics.micmaestro.controller

import com.ics.micmaestro.models.Movie
import com.ics.micmaestro.service.MovieService
import org.springframework.web.bind.annotation.*

//http://localhost:8080/movies
@RestController
@RequestMapping(value = ["movies"])
class MovieController(private val movieService: MovieService){

    @GetMapping
    fun findAll():List<Movie> = movieService.findAll()

    @GetMapping(value = "{id}")
    fun findById(@PathVariable id:Long)=movieService.findById(id)

    @PostMapping
    fun saveMovie(@RequestBody movie: Movie) = movieService.saveMovie(movie)

    @DeleteMapping(value ="{id}")
    fun deleteMovie(@PathVariable id: Long) = movieService.deleteMovie(id)


}
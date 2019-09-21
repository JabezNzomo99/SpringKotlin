package com.ics.micmaestro.controller

import com.ics.micmaestro.Create
import com.ics.micmaestro.Update
import com.ics.micmaestro.models.Actor
import com.ics.micmaestro.models.Movie
import com.ics.micmaestro.service.ActorService
import com.ics.micmaestro.service.MovieService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

//http://localhost:8080/movies
@RestController
@RequestMapping(value = ["movies"])
class MovieController(private val movieService: MovieService){

    @GetMapping
    fun findAll():List<Movie> = movieService.findAll()

    @GetMapping(value = ["{id}"])
    fun findById(@PathVariable id:Long)=movieService.findById(id)

    @PostMapping
    fun saveMovie(@Validated(Create::class) @RequestBody movie: Movie) = movieService.saveMovie(movie)

    @DeleteMapping(value = ["{id}"])
    fun deleteMovie(@PathVariable id: Long) = movieService.deleteMovie(id)

    @PatchMapping
    fun updateMovie(@RequestBody movie: Movie) = movieService.update(movie)

    @PatchMapping(value = ["{id}"])
    fun updateMovie(@Validated(Update::class) @PathVariable id: Long, @RequestBody movie: Movie) = movieService.update(movie)

    @PostMapping(value = ["{id}/actors"])
    fun createActor(@Validated(Create::class) @PathVariable id: Long,@RequestBody actor:Actor) = movieService.createActor(id,actor)


}
package com.ics.micmaestro.service

import com.ics.micmaestro.models.Actor
import com.ics.micmaestro.models.Movie
import org.springframework.stereotype.Service


interface MovieService {

    fun findAll():List<Movie>
    fun findById(id:Long):Movie
    fun saveMovie(movie:Movie):Movie

    //Function to delete a movie item
    fun deleteMovie(id:Long)

    //Function to add a movie
    fun create(movie: Movie):Movie

    fun update(movie: Movie):Movie

    fun update(id:Long,movie: Movie):Movie

    fun createMovies(movies:List<Movie>):List<Movie>

    fun createActor(id: Long, actor: Actor): Actor

}
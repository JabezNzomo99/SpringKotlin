package com.ics.micmaestro.service

import com.ics.micmaestro.models.Movie
import org.springframework.stereotype.Service


interface MovieService {

    fun findAll():List<Movie>
    fun findById(id:Long):Movie
    fun saveMovie(movie:Movie):Movie
    fun deleteMovie(id:Long)

}
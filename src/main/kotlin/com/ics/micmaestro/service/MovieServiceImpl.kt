package com.ics.micmaestro.service

import com.ics.micmaestro.models.Movie
import com.ics.micmaestro.repositories.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl (private val movieRepository: MovieRepository) : MovieService {

    override fun deleteMovie(id: Long) = movieRepository.deleteById(id)

    override fun saveMovie(movie: Movie)= movieRepository.save(movie)

    override fun findById(id: Long): Movie = movieRepository.findById(id).get()

    override fun findAll(): List<Movie> = movieRepository.findAll()


}
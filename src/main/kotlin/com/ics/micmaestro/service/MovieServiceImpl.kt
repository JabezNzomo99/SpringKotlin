package com.ics.micmaestro.service

import com.ics.micmaestro.NotFoundException
import com.ics.micmaestro.models.Actor
import com.ics.micmaestro.models.Movie
import com.ics.micmaestro.repositories.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl (private val movieRepository: MovieRepository, private val actorService: ActorService) : MovieService {
    override fun createActor(id: Long, actor: Actor): Actor {
        val movie = findById(id)
        actor.movie = movie
        return actorService.createActor(actor)
    }

    override fun createMovies(movies: List<Movie>): List<Movie> = movieRepository.saveAll(movies)

    override fun create(movie: Movie) = movieRepository.save(movie)
    override fun update(movie: Movie): Movie {
        val foundMovie = findById(movie.id!!)
        foundMovie.name = movie.name
        foundMovie.yearReleased = movie.yearReleased
        return movieRepository.save(foundMovie)
    }

    override fun update(id: Long, movie: Movie): Movie {
        var foundMovie = findById(id)
        foundMovie.name = movie.name
        foundMovie.yearReleased = movie.yearReleased
        return movieRepository.save(foundMovie)

    }

    override fun deleteMovie(id: Long) = movieRepository.deleteById(id)

    override fun saveMovie(movie: Movie)= movieRepository.save(movie)

    override fun findById(id: Long): Movie = movieRepository.findById(id).orElseThrow{
        NotFoundException("No record with id $id found")
    }

    override fun findAll(): List<Movie> = movieRepository.findAll()


}
package com.ics.micmaestro

import com.ics.micmaestro.models.Movie
import com.ics.micmaestro.repositories.MovieRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DummyData(private val movieRepository: MovieRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val movies = listOf(Movie(name = "Avengers", yearReleased = "2012"),Movie(name = "SpiderMan", yearReleased = "1991"), Movie(name = "John Wick III",yearReleased = "2018"), Movie(name = "Hobbs and Shaw",yearReleased = "2019"))
        movieRepository.saveAll(movies)
    }
}
package com.ics.micmaestro

import com.ics.micmaestro.models.Actor
import com.ics.micmaestro.models.Category
import com.ics.micmaestro.models.Movie
import com.ics.micmaestro.repositories.CategoryRepository
import com.ics.micmaestro.repositories.MovieRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DummyData(private val movieRepository: MovieRepository, private val categoryRepository: CategoryRepository) : CommandLineRunner {

    //The run method will always be called when running the main application
    override fun run(vararg args: String?) {
        val actionCategory = Category(name = "Action")
        val comedyCategory = Category(name = "Comedy")
        val actors = listOf<Actor>()
        val tomJerry = Movie(name = "Tom & Jerry",yearReleased = "1973",actors = actors)
        val myMovie = Movie(name = "Boom",yearReleased = "1654",actors = actors)
        actionCategory.movies.add(tomJerry)
        comedyCategory.movies.add(myMovie)
        categoryRepository.saveAll(listOf(actionCategory,comedyCategory))

    }
}
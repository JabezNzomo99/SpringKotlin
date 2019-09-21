package com.ics.micmaestro

import com.ics.micmaestro.models.Movie
import org.springframework.boot.CommandLineRunner
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject


class TestingRest:CommandLineRunner {
    override fun run(vararg args: String?) {
        val restTemplate = RestTemplate()
        val response = restTemplate.exchange(
                REST_API_URL,
                HttpMethod.GET,
                null,
                object : ParameterizedTypeReference<List<Movie>>(){}
        )
        val movies = response.body
        movies?.forEach {
            print(it)
        }

        val movie = restTemplate.getForObject(
                "http://10.51.10.111:9090/movies/3",
                Movie::class.java
        )
        println(movie)

        val REST_API_URL_SEARCH = "http://10.51.10.111:9090/movies/search?name=" + movie?.name
        val movieByName = restTemplate.getForObject(
                REST_API_URL_SEARCH,
                Movie::class.java
        )

        println("Searched Movie: $movieByName")


    }

    companion object{
        const val REST_API_URL = "http://10.51.10.111:9090/movies"
    }

}


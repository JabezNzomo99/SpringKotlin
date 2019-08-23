package com.ics.micmaestro.repositories

import com.ics.micmaestro.models.Movie
import org.springframework.data.jpa.repository.JpaRepository

interface MovieRepository:JpaRepository<Movie,Long> {
}
package com.ics.micmaestro.repositories

import com.ics.micmaestro.models.Actor
import org.springframework.data.jpa.repository.JpaRepository

interface ActorRepository:JpaRepository<Actor,Long> {
}
package com.ics.micmaestro.service

import com.ics.micmaestro.models.Actor

interface ActorService {

    fun createActor(actor:Actor):Actor
    fun updateActor(actor: Actor):Actor
    fun updateActor(id:Long, actor: Actor):Actor
    fun deleteActor(id:Long)
    fun findActorById(id:Long):Actor
    fun findAllActors():List<Actor>
}
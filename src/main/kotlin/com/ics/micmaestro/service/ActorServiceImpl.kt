package com.ics.micmaestro.service

import com.ics.micmaestro.models.Actor
import com.ics.micmaestro.repositories.ActorRepository
import javassist.NotFoundException
import org.springframework.stereotype.Service

@Service
class ActorServiceImpl (private val actorRepository: ActorRepository) : ActorService {
    override fun createActor(actor: Actor) = actorRepository.save(actor)

    override fun updateActor(actor: Actor): Actor {
        val foundActor = findActorById(actor.id)
        foundActor.name = actor.name
        return actorRepository.save(foundActor)

    }

    override fun updateActor(id: Long, actor: Actor): Actor {
        val foundActor = findActorById(id)
        foundActor.name = actor.name
        return actorRepository.save(foundActor)
    }

    override fun deleteActor(id: Long) = actorRepository.deleteById(id)

    override fun findActorById(id: Long): Actor = actorRepository.findById(id).orElseThrow {
        NotFoundException("The id $id does not exist")
    }
    override fun findAllActors(): List<Actor> = actorRepository.findAll()
}
package com.ics.micmaestro.controller

import com.ics.micmaestro.Create
import com.ics.micmaestro.Update
import com.ics.micmaestro.models.Actor
import com.ics.micmaestro.service.ActorService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

//http://localhost:8080/movies
@RestController
@RequestMapping(value = ["actors"])
class ActorController(private val actorService: ActorService){

    @PostMapping
    fun createActor(@Validated(Create::class) @RequestBody actor:Actor) = actorService.createActor(actor)

    @GetMapping
    fun findAllActors() = actorService.findAllActors()

    @GetMapping(value = ["{id}"])
    fun findActorById(@PathVariable id:Long) = actorService.findActorById(id)

    @PatchMapping
    fun updateActor(@Validated(Update::class) @RequestBody actor: Actor) = actorService.updateActor(actor)

}
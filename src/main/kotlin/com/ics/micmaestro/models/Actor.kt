package com.ics.micmaestro.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.ics.micmaestro.Create
import com.ics.micmaestro.Update
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "actors")
data class Actor (@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id") var id:Long,
                  @Column(name="name") var name:String,
                  @ManyToOne @JoinColumn(name = "movie_id_fk") @JsonIgnore var movie: Movie?)

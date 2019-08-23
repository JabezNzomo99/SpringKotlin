package com.ics.micmaestro.models

import javax.persistence.*

@Entity
@Table(name = "movies")
data class Movie (@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name="id")val id:Long?=null,
                  @Column(name = "name")
                  val name:String,
                  @Column(name = "year_released")
                  val yearReleased:String){
}
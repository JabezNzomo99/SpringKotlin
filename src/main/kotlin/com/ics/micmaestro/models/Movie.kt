package com.ics.micmaestro.models

import com.ics.micmaestro.Create
import com.ics.micmaestro.Update
import org.springframework.lang.NonNull
import javax.persistence.*
import javax.validation.constraints.NotNull
import kotlin.collections.HashSet

@Entity
@Table(name = "movies")
data class Movie (@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name="id") @NotNull(groups = [Update::class]) var id:Long?=null,
                  @Column(name = "name")
                  @NotNull(groups = [Create::class,Update::class])
                  var name:String,
                  @Column(name = "year_released")
                  var yearReleased:String,
                  @OneToMany(mappedBy = "movie")
                  var actors:List<Actor>
                  ){
                @ManyToMany(mappedBy = "movies")
                val categories:MutableList<Category> = mutableListOf<Category>()

}


package com.ics.micmaestro.models

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import kotlin.collections.HashSet

@Entity
@Table(name = "categories")
data class Category (@Id @GeneratedValue(strategy = GenerationType.AUTO) var id:Long?=null,
                     @Column(name="name") var name:String
                     ){

    @ManyToMany(cascade = [CascadeType.ALL])
    @JsonIgnore
    @JoinTable(
            name = "categories_movies",
            joinColumns = [JoinColumn(name = "category_id",referencedColumnName = "id")],
            inverseJoinColumns = [JoinColumn(name = "movie_id",referencedColumnName = "id")]

    )
    val movies:MutableList<Movie> = mutableListOf<Movie>()


}
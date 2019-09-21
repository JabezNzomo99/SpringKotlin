package com.ics.micmaestro

fun <T>Collection<T>.printCollection(){
    this.forEach {
        println(it)
    }
}
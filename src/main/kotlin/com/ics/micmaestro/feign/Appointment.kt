package com.ics.micmaestro.feign

data class Appointment(val id:Long, val student: Student, val teacher:Lecturer, val confirmed:Boolean)

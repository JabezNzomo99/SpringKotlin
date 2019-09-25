package com.ics.micmaestro.feign

import feign.Param
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.cloud.openfeign.SpringQueryMap
import org.springframework.web.bind.annotation.*

@FeignClient(name = "lecturers", url= "http://localhost:1000",configuration = [FeignConfig::class])
interface FeignRestLecturersClient {

    //Get request to fetch a list of lecturers
    @RequestMapping(method = [RequestMethod.GET], value = ["lecturers"])
    fun getAllLecturers():List<Lecturer>

    @RequestMapping(method = [RequestMethod.GET], value = ["students"])
    fun getStudentById(@RequestParam(value = "studentNumber") studentNumber: Int):Student

    @RequestMapping(method = [RequestMethod.POST], value=["students"])
    fun createStudent(@RequestBody student:Student):Student

    @RequestMapping(method = [RequestMethod.POST],value = ["appointments"])
    fun createAppointment(@RequestBody createAppointment: CreateAppointment):Appointment

    @RequestMapping(method = [RequestMethod.PATCH], value = ["appointments/{appointmentId}/"])
    fun updateAppointment(@PathVariable(name = "appointmentId") appointmentId:Long, @RequestParam(name = "studentId") studentId: Long):Appointment
}
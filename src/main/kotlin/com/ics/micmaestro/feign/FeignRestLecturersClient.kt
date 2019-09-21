package com.ics.micmaestro.feign

import feign.Param
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.cloud.openfeign.SpringQueryMap
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = "lecturers", url= "https://c426a404.ngrok.io")
interface FeignRestLecturersClient {

    @RequestMapping(method = [RequestMethod.GET], value = ["lecturers"])
    fun getAllLecturers():List<Lecturer>

    @RequestMapping(method = [RequestMethod.GET], value = ["students"])
    fun getStudentById(@SpringQueryMap studentParameter: StudentParameter):Student

    @RequestMapping(method = [RequestMethod.POST], value=["students"])
    fun createStudent(@RequestBody student:Student):Student

    @RequestMapping(method = [RequestMethod.POST],value = ["appointments"])
    fun createAppointment(@RequestBody createAppointment: CreateAppointment):Appointment

    @RequestMapping(method = [RequestMethod.PATCH], value = ["appointments/{appointmentId}/"])
    fun updateAppointment(@PathVariable(value = "appointmentId") appointmentId:Long, @SpringQueryMap studentParameter: StudentId):Appointment
}
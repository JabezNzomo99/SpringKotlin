package com.ics.micmaestro

import com.ics.micmaestro.feign.*
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class TestFeignRestLecturer(private val feignRestLecturersClient: FeignRestLecturersClient):CommandLineRunner{
    override fun run(vararg args: String?) {
        val allLecturers = feignRestLecturersClient.getAllLecturers()
        allLecturers.printCollection()

        val newStudent = Student(null,"91234","Chronixx",null)
        val createdStudent=feignRestLecturersClient.createStudent(student = newStudent)
        println("Student Created:$createdStudent")

        val student = feignRestLecturersClient.getStudentById(StudentParameter(91234))
        println(" Retrieved Student : $student")

        val appointment = feignRestLecturersClient.createAppointment(CreateAppointment(studentId = student.id?.toInt()!!,teacherId = 3))
        println("Created Appointment: $appointment")

        val confirmedAppointment = feignRestLecturersClient.updateAppointment(appointmentId = appointment.id,studentParameter = StudentId(student.id))
        println("Confirmed Appointment: $confirmedAppointment")
    }
}

package com.ics.micmaestro.cat

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class TestFeignCat(private val feignCat:FeignCat): CommandLineRunner{
    companion object{
        const val VILLA_ROSA_ID = 6
        const val VILLA_ROSA_KITCHEN = 11
    }
    override fun run(vararg args: String?) {
        val registeredStudent = feignCat.registerStudent(Student(null,"91279","Magomere",null,null))
        println("Registered Student: $registeredStudent")

        val requestedAttachment = feignCat.requestAttachment(VILLA_ROSA_ID.toLong(), studentId = registeredStudent.id!!)
        println("Requested Attachment: $requestedAttachment")

        val requestedDepartment = feignCat.requestDepartment(studentId = registeredStudent.id.toLong(), departmentId = VILLA_ROSA_KITCHEN.toLong(),companyId = VILLA_ROSA_ID.toLong())
        println("Requested Department: $requestedDepartment")

        val delete = feignCat.rejectAttachment(Delete(studentId = registeredStudent.id.toLong(), companyId = VILLA_ROSA_ID.toLong(), departmentId = VILLA_ROSA_KITCHEN.toLong()))
        println("$delete")
    }

}
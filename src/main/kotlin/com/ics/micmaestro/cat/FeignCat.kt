package com.ics.micmaestro.cat

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.*

@FeignClient(name = "cat", url = "http://10.51.10.111:2000")
interface FeignCat {

    @RequestMapping(method = [RequestMethod.POST], value = ["students"])
    fun registerStudent(@RequestBody student:Student):Student

    @RequestMapping(method = [RequestMethod.POST], value = ["companies/{companyId}/attachments"])
    fun requestAttachment(@PathVariable(name = "companyId") companyId:Long, @RequestParam(name = "studentId") studentId:Long):Attachment

    @RequestMapping(method = [RequestMethod.PATCH], value = ["companies/{companyId}/attachments"])
    fun requestDepartment(@PathVariable(name = "companyId") companyId: Long, @RequestParam(name = "studentId") studentId: Long, @RequestParam(name = "departmentId") departmentId:Long ):Attachment

    @RequestMapping(method = [RequestMethod.DELETE], value = ["departments"])
    fun rejectAttachment(@RequestBody delete:Delete)


}
**A simple REST API built using Spring Framework and Kotlin**
`Spring` `Kotlin` `JPA` `Hibernate`
#### Work in progress

##### ** Feign Client Tutorial **

The tutorial below is a simple personalized documentation of how to set up feign client and how to make different requests.
Feign is a declarative web service client. It makes writing web service clients easier. To use Feign create an interface and annotate it. It has pluggable annotation support including Feign annotations and JAX-RS annotations. Feign also supports pluggable encoders and decoders. Spring Cloud adds support for Spring MVC annotations and for using the same HttpMessageConverters used by default in Spring Web. Spring Cloud integrates Ribbon and Eureka to provide a load balanced http client when using Feign.

1. Adding feign dependencies to build.gradle.kts
    

    //Dependencies
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:2.1.3.RELEASE")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("com.netflix.feign:feign-gson:8.18.0")
    implementation("com.netflix.feign:feign-okhttp:8.18.0")
    implementation("io.github.openfeign:feign-httpclient:10.4.0")
    
    val springCloudVersion = "Greenwich.SR3"
    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
        }
    } 
    
 2. Enable feign in the spring application by annotating main application class with @EnableFeignClients
        
        
    @SpringBootApplication
    @EnableFeignClients
    class MaestroApplication
    
    fun main(args: Array<String>) {
        runApplication<MaestroApplication>(*args)
    
    }
    
3. Create an interface and define REST functions, feign will implement these methods for you. Annotate the class with @FeignClient and ass the name and base URL
    
        @FeignClient(name = "lecturers", url= "your_url")
        interface FeignRestLecturersClient {
        }

4. Defining REST functions
    _** GET **_
        
        @RequestMapping(method = [RequestMethod.GET], value = ["lecturers"])
        fun getAllLecturers():List<Lecturer>
         
     _** POST **_  
       
        @RequestMapping(method = [RequestMethod.POST], value=["students"])
        fun createStudent(@RequestBody student:Student):Student
      
      _** GET with query parameters **_    
        Use the @SpringQueryMap annotation and define a POJO that contains the parameter fields.
        
        @RequestMapping(method = [RequestMethod.GET], value = ["students"])
        fun getStudentById(@SpringQueryMap studentParameter: StudentParameter):Student
      
      _** GET with path variables **_   
      
        @RequestMapping(method = [RequestMethod.GET], value = ["students/{id}"])
        fun getStudentById(@PathVariable(value="id") id: Long):Student
        
    _** PATCH with path variables & query parameters**_ 
        
        @RequestMapping(method = [RequestMethod.PATCH], value = ["appointments/{appointmentId}/"])
        fun updateAppointment(@PathVariable(value = "appointmentId") appointmentId:Long, @SpringQueryMap studentParameter: StudentId):Appointment
      
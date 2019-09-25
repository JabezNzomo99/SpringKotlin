package com.ics.micmaestro.feign

import feign.Logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfig {

    @Bean
    fun feignLoggerLevel()=Logger.Level.FULL

}
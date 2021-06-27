package br.com.estudante.customerapi.services

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.time.Duration

@Service
class ServiceForGetCepApiExternal {
    val connectTimeOut: Long = 10000
    val readTimeOut: Long = 10000

    @Bean
    fun getRestTemplate(): RestTemplate {
        return RestTemplateBuilder()
            .setConnectTimeout(Duration.ofMillis(connectTimeOut))
            .setReadTimeout(Duration.ofMillis(readTimeOut)).build()
    }
}
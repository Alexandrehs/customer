package br.com.estudante.customerapi.config

import java.time.Duration
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class RestTemplateConfiguration(
    @Value("\${app.client.connect-time-out}") private val connectTimeOut: Long,
    @Value("\${app.client.read-time-out}") private val readTimeOut: Long
) {

    @Bean
    fun createDefaultRestTemplate(): RestTemplate {
        return RestTemplateBuilder()
            .setConnectTimeout(Duration.ofMillis(connectTimeOut))
            .setReadTimeout(Duration.ofMillis(readTimeOut)).build()
    }
}
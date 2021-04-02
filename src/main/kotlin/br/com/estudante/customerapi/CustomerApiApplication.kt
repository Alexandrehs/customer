package br.com.estudante.customerapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@Configuration
class CustomerApiApplication {
	@Bean
	fun getRestTemplate() : RestTemplate {
		return RestTemplate()
	}
}

fun main(args: Array<String>) {
	runApplication<CustomerApiApplication>(*args)
}

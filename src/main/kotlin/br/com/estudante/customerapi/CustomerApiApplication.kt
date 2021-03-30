package br.com.estudante.customerapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*

@SpringBootApplication
class CustomerApiApplication

fun main(args: Array<String>) {
	runApplication<CustomerApiApplication>(*args)
}
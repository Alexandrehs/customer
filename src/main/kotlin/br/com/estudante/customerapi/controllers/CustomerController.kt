package br.com.estudante.customerapi.controllers

import br.com.estudante.customerapi.models.Customer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customer")
class CustomerController {

  @GetMapping("/all")
  fun customerAll() : Customer {
    val newCustomer = Customer( 1,"Alexandre Silva", "38183183")

    return newCustomer
  }
}
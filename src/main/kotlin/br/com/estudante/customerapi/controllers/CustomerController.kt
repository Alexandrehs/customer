package br.com.estudante.customerapi.controllers

import br.com.estudante.customerapi.models.Customer
import br.com.estudante.customerapi.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@Validated
@RequestMapping("/customer")
class CustomerController {

  @Autowired
  lateinit var customerRepository : CustomerRepository

  @PostMapping("/add")
  fun add(@RequestBody @Valid customer: Customer) : Customer {
    var newCustomer = customerRepository.save(customer)
    return customer
  }
}
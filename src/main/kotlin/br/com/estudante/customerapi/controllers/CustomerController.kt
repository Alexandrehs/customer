package br.com.estudante.customerapi.controllers

import br.com.estudante.customerapi.models.Customer
import br.com.estudante.customerapi.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customer")
class CustomerController {

  @Autowired
  lateinit var customerRepository : CustomerRepository

  @PostMapping("/add")
  fun add(@RequestBody customer: Customer) : Customer {
    customerRepository.save(customer)
    return customer
  }

  @GetMapping("/all")
  fun all() : List<Customer> {
    return customerRepository.findAll()
  }
}
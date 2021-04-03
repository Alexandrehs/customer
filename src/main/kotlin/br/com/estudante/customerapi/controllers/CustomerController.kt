package br.com.estudante.customerapi.controllers

import br.com.estudante.customerapi.entity.CustomerRequest
import br.com.estudante.customerapi.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/customer")
class CustomerController {

  @Autowired
  lateinit var customerRepository: CustomerRepository

 @PostMapping
 fun create(@RequestBody @Valid customerRequest: CustomerRequest) : Long? {
   return customerRequest.id
 }
}

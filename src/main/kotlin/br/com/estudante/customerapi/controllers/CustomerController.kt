package br.com.estudante.customerapi.controllers

import br.com.estudante.customerapi.rest.CustomerRequest
import br.com.estudante.customerapi.rest.CustomerResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/customer")
class CustomerController {

 @PostMapping
 fun create(@RequestBody @Valid customerRequest: CustomerRequest) : ResponseEntity<CustomerResponse> {
   val newCustomerId = CustomerResponse(id = customerRequest.id.toString())
   return ResponseEntity.status(HttpStatus.CREATED).body(newCustomerId)
 }
}

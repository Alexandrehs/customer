package br.com.estudante.customerapi.controllers

import br.com.estudante.customerapi.entity.CustomerEntity
import br.com.estudante.customerapi.repository.CustomerRepository
import br.com.estudante.customerapi.rest.CustomerRequest
import br.com.estudante.customerapi.rest.CustomerResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    lateinit var repository: CustomerRepository

    @PostMapping
    fun create(@RequestBody @Valid customerRequest: CustomerRequest): ResponseEntity<CustomerResponse> {
        val customerEntity = repository.save(CustomerEntity(customerRequest))
        val customerResponse = CustomerResponse(customerEntity)
        return ResponseEntity.status(HttpStatus.CREATED).body(customerResponse)
    }
}

package br.com.estudante.customerapi.rest

import br.com.estudante.customerapi.services.CustomerService
import javax.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerResource {

    @Autowired
    lateinit var customerService: CustomerService

    @PostMapping
    fun create(@RequestBody @Valid customerRequest: CustomerRequest): ResponseEntity<CustomerResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerRequest))
    }
}

package br.com.estudante.customerapi.rest

import br.com.estudante.customerapi.entity.CustomerEntity
import br.com.estudante.customerapi.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import br.com.estudante.customerapi.rest.CustomerResponse

@RestController
@RequestMapping("/customer")
class CustomerResource {

    @Autowired
    lateinit var repository: CustomerRepository

    @PostMapping
    fun create(@RequestBody @Valid customerRequest: CustomerRequest): ResponseEntity<CustomerResponse> {
        val customerEntity = repository.save(CustomerEntity(customerRequest))
        val customerResponse = CustomerResponse(customerEntity)
        print(customerRequest)
        return ResponseEntity.status(HttpStatus.CREATED).body(customerResponse)
    }
}

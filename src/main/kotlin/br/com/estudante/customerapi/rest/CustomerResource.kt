package br.com.estudante.customerapi.rest

import br.com.estudante.customerapi.controllers.AddressController
import br.com.estudante.customerapi.entity.CustomerEntity
import br.com.estudante.customerapi.repository.AddressRepository
import br.com.estudante.customerapi.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import javax.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customer")
class CustomerResource {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Autowired
    lateinit var addressRepository: AddressRepository

    @PostMapping
    fun create(@RequestBody @Valid customerRequest: CustomerRequest) : ResponseEntity<CustomerResponse> {
        val customerAddress =
            AddressController().getAddress(customerRequest.postalCode!!, addressRepository)
        val customerSalved = customerRepository.save(CustomerEntity(customerRequest, customerAddress))
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerResponse(customerSalved.id))
    }
}

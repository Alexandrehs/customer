package br.com.estudante.customerapi.service

import br.com.estudante.customerapi.entity.CustomerEntity
import br.com.estudante.customerapi.repository.CustomerRepository
import br.com.estudante.customerapi.rest.CustomerRequest
import br.com.estudante.customerapi.rest.CustomerResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerService {

  @Autowired
  lateinit var repository: CustomerRepository

  fun toCustomerEntity(customerRequest: CustomerRequest) : ResponseEntity<CustomerResponse> {
    val newCustomer = CustomerEntity(
      UUID.randomUUID().toString(),
      customerRequest.name,
      customerRequest.personCode,
      customerRequest.postalCode,
      customerRequest.email
    )

    return ResponseEntity.status(HttpStatus.CREATED).body(CustomerResponse(repository.save(newCustomer).id))
  }
}
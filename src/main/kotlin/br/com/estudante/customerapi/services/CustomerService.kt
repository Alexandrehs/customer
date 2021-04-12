package br.com.estudante.customerapi.services

import br.com.estudante.customerapi.repository.CustomerRepository
import br.com.estudante.customerapi.rest.CustomerRequest
import br.com.estudante.customerapi.rest.CustomerResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CustomerService {

  @Autowired
  lateinit var repository : CustomerRepository

  fun addCustomer(customer: CustomerRequest) : ResponseEntity<CustomerResponse> {
    val newCustomer = repository.save(customer)
    return ResponseEntity.status(HttpStatus.CREATED).body(CustomerResponse(newCustomer.id))
  }
}
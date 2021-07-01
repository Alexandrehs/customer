package br.com.estudante.customerapi.controllers

import br.com.estudante.customerapi.entity.CustomerEntity
import br.com.estudante.customerapi.repository.CustomerRepository
import br.com.estudante.customerapi.rest.CustomerRequest
import br.com.estudante.customerapi.rest.CustomerResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerController {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Autowired
    lateinit var addressController: AddressController

    public fun createCustomer(customerRequest: CustomerRequest) : CustomerResponse {
        val address = addressController.getAddress(customerRequest.postalCode!!)
        val customer = customerRepository.save(CustomerEntity(customerRequest, address))

        return CustomerResponse(customer.id)
    }
}
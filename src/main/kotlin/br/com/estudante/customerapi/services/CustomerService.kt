package br.com.estudante.customerapi.services

import br.com.estudante.customerapi.entity.CustomerEntity
import br.com.estudante.customerapi.repository.CustomerRepository
import br.com.estudante.customerapi.rest.CustomerRequest
import br.com.estudante.customerapi.rest.CustomerResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Autowired
    lateinit var addressController: AddressService

    fun createCustomer(customerRequest: CustomerRequest): CustomerResponse {
        val address = addressController.resolveAddress(customerRequest.postalCode!!)
        val customer = customerRepository.save(CustomerEntity(customerRequest, address))

        return CustomerResponse(customer.id)
    }
}
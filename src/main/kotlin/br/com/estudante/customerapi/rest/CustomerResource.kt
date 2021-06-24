package br.com.estudante.customerapi.rest

import br.com.estudante.customerapi.entity.CustomerEntity
import br.com.estudante.customerapi.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import javax.validation.Valid
import br.com.estudante.customerapi.sevices.AddressService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customer")
class CustomerResource {

    @Autowired
    lateinit var repository: CustomerRepository
    @Autowired
    lateinit var addressService: AddressService

    @PostMapping
    fun create(@RequestBody @Valid customerRequest: CustomerRequest) : ResponseEntity<CustomerResponse?> {
        val addressCustomer =  addressService.getAddress(customerRequest.postalCode!!)
        if(addressCustomer != null) {
            customerRequest.road = addressCustomer!!.address
            customerRequest.district = addressCustomer!!.district
            customerRequest.city = addressCustomer!!.city
            customerRequest.state = addressCustomer!!.state
            return ResponseEntity.status(HttpStatus.OK).body(CustomerResponse(repository.save(CustomerEntity(customerRequest)).id))
        }

        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }
}

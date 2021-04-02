package br.com.estudante.customerapi.controllers

import br.com.estudante.customerapi.models.CEPModel
import br.com.estudante.customerapi.models.Customer
import br.com.estudante.customerapi.repository.CustomerRepository
import br.com.estudante.customerapi.service.CepService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/customer")
class CustomerController {

  @Autowired
  lateinit var customerRepository : CustomerRepository
  @Autowired
  lateinit var cepService :  CepService

  @PostMapping
  fun create(@RequestBody @Valid customer: Customer) : Long {
    var cepValid = cepService.getCep(customer.cep)

    if(cepValid != null) {
      return customerRepository.save(customer).id
    } else {
      return 0
    }
  }

  @GetMapping
  fun getAll() : List<Customer> {
    return customerRepository.findAll()
  }
}

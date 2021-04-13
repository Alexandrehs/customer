package br.com.estudante.customerapi.controllers

import br.com.estudante.customerapi.entity.CustomerEntity
import br.com.estudante.customerapi.exceptions.CustomerException
import br.com.estudante.customerapi.repository.CustomerRepository
import br.com.estudante.customerapi.rest.CustomerRequest
import br.com.estudante.customerapi.rest.CustomerResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/customer")
class CustomerController {

  @Autowired
  lateinit var repository: CustomerRepository

 @PostMapping
 fun create(@RequestBody @Valid customerRequest: CustomerRequest) : ResponseEntity<CustomerResponse> {
   val newCustomer = CustomerEntity(
     UUID.randomUUID().toString(),
     customerRequest.name,
     customerRequest.personCode,
     customerRequest.postalCode,
     customerRequest.email
   )

   return ResponseEntity.status(HttpStatus.CREATED).body(CustomerResponse(repository.save(newCustomer).id))
 }

 @ExceptionHandler(MethodArgumentNotValidException::class)
 fun handleCustomerNotValidException(ex : MethodArgumentNotValidException, request : WebRequest) : ResponseEntity<List<CustomerException>> {
   val fieldError : List<FieldError> = ex.fieldErrors
   val errorList = fieldError.map { CustomerException(it.field, it.defaultMessage.toString()) }

   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList)
 }
}


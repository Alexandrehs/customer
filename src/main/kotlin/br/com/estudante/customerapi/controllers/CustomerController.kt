package br.com.estudante.customerapi.controllers

import br.com.estudante.customerapi.exceptions.CustomerException
import br.com.estudante.customerapi.rest.CustomerRequest
import br.com.estudante.customerapi.rest.CustomerResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.request.WebRequest
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/customer")
class CustomerController {

  lateinit var customerException : CustomerException

 @PostMapping
 fun create(@RequestBody @Valid customerRequest: CustomerRequest) : ResponseEntity<CustomerResponse> {
   val newCustomerId = CustomerResponse(id = UUID.randomUUID().toString())
   return ResponseEntity.status(HttpStatus.CREATED).body(newCustomerId)
 }

 @ExceptionHandler(MethodArgumentNotValidException::class)
 fun handleCustomerNotFoundException(ex : MethodArgumentNotValidException, request : WebRequest) : ResponseEntity<CustomerException> {
   val fieldError : List<FieldError> = ex.getFieldErrors()

   for(fe in fieldError) {
     val field: String = fe.field
     val message: String = fe.defaultMessage.toString()
     customerException = CustomerException(field, message)
   }

   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customerException)
 }
}

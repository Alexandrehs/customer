package br.com.estudante.customerapi.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleCustomerNotValidException(ex: MethodArgumentNotValidException, request: WebRequest): ResponseEntity<List<CustomerException>> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ex.fieldErrors.map { CustomerException(it.field, it.defaultMessage.toString()) })
    }

}

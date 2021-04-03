package br.com.estudante.customerapi.repository

import br.com.estudante.customerapi.entity.CustomerRequest
import org.springframework.data.jpa.repository.JpaRepository


interface CustomerRepository : JpaRepository<CustomerRequest, Long> {
}
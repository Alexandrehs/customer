package br.com.estudante.customerapi.repository

import br.com.estudante.customerapi.models.Customer
import org.springframework.data.jpa.repository.JpaRepository


interface CustomerRepository : JpaRepository<Customer, Long> {
}
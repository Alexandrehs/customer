package br.com.estudante.customerapi.repository

import br.com.estudante.customerapi.entity.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<CustomerEntity, String> {
}
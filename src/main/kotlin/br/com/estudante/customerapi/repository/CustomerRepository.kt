package br.com.estudante.customerapi.repository

import br.com.estudante.customerapi.entity.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<CustomerEntity, String> {
}
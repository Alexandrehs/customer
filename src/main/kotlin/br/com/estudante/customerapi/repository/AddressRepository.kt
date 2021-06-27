package br.com.estudante.customerapi.repository

import br.com.estudante.customerapi.entity.AddressEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository : JpaRepository<AddressEntity, String> {
    fun findByPostalCode(postalCode: String): AddressEntity?
}
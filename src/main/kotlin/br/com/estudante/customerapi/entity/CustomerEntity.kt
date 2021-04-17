package br.com.estudante.customerapi.entity

import br.com.estudante.customerapi.rest.CustomerRequest
import org.hibernate.annotations.CreationTimestamp
import java.sql.Timestamp
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "customers")
data class CustomerEntity(

    @Id
    val id: String,

    val name: String,

    val personCode: String,

    val postalCode: String,

    val email: String
) {
    constructor(customerRequest: CustomerRequest) : this(
        id = UUID.randomUUID().toString(),
        name = customerRequest.name!!,
        personCode = customerRequest.personCode!!,
        postalCode = customerRequest.postalCode!!,
        email = customerRequest.email!!
    )

    @field:CreationTimestamp
    lateinit var created: Timestamp
}

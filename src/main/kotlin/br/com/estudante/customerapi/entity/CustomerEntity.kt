package br.com.estudante.customerapi.entity

import br.com.estudante.customerapi.rest.CustomerRequest
import org.hibernate.annotations.CreationTimestamp
import java.sql.Timestamp
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "customers")
data class CustomerEntity(

    @Id
    val id: String,

    @Column(name = "name")
    val name: String,

    @Column(name = "person_code")
    val personCode: String,

    @Column(name = "email")
    val email: String,

    @Column(name = "postal_code")
    val postalCode: String,

    @Column(name = "road")
    val road: String,

    @Column(name = "number")
    val number: String,

    @Column(name = "district")
    val district: String,

    @Column(name = "city")
    val city: String,

    @Column(name = "state")
    val state: String,

    @Column(name = "complement")
    val complement: String

) {
    constructor(customerRequest: CustomerRequest) : this(
        id = UUID.randomUUID().toString(),
        name = customerRequest.name!!,
        personCode = customerRequest.personCode!!,
        email = customerRequest.email!!,
        postalCode = customerRequest.postalCode!!,
        road = customerRequest.road!!,
        number = customerRequest.number!!,
        district = customerRequest.district!!,
        city = customerRequest.city!!,
        state = customerRequest.state!!,
        complement = customerRequest.complement!!
    )

    @field:CreationTimestamp
    lateinit var created: Timestamp
}

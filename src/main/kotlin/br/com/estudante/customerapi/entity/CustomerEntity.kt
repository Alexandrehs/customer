package br.com.estudante.customerapi.entity

import br.com.estudante.customerapi.rest.CustomerRequest
import org.hibernate.annotations.CreationTimestamp
import java.sql.Timestamp
import java.util.UUID
import javax.persistence.*
import javax.validation.constraints.Null

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

    @Column(name = "number_of_road")
    val numberOfRoad: String,

    @Column(name = "complement")
    val complement: String?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    val addressEntity: AddressEntity

) {
    constructor(customerRequest: CustomerRequest, addressEntity: AddressEntity) : this(
        id = UUID.randomUUID().toString(),
        name = customerRequest.name!!,
        personCode = customerRequest.personCode!!,
        email = customerRequest.email!!,
        postalCode = customerRequest.postalCode!!,
        numberOfRoad = customerRequest.numberOfRoad!!,
        complement = customerRequest.complement,
        addressEntity = addressEntity
    )

    @field:CreationTimestamp
    lateinit var created: Timestamp
}

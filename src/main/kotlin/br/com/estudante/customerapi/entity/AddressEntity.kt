package br.com.estudante.customerapi.entity

import br.com.estudante.customerapi.rest.AddressRequest
import br.com.estudante.customerapi.rest.AddressResponse
import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList

@Entity
@Table(name = "address")
data class AddressEntity (

    @Id
    val id: String,

    @Column(name = "road")
    val road: String,

    @Column(name = "district")
    val district: String,

    @Column(name = "city")
    val city: String,

    @Column(name = "state")
    val state: String,

    @Column(name = "postalcode")
    val postalCode: String,

    @OneToMany(mappedBy = "addressEntity")
    var customer: List<CustomerEntity> = ArrayList<CustomerEntity>()
)
package br.com.estudante.customerapi.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "address")
data class AddressEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "street")
    val street: String,

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

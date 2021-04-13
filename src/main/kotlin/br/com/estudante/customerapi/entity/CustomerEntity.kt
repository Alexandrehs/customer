package br.com.estudante.customerapi.entity

import org.hibernate.annotations.CreationTimestamp
import java.sql.Timestamp
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "customers")
data class CustomerEntity (

  @Id
  val id : String,

  val name : String?,

  val personCode : String?,

  val postalCode : String?,

  val email : String?
) {

  @field:CreationTimestamp
  lateinit var created : Timestamp
}
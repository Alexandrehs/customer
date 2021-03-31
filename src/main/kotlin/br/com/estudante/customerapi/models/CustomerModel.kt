package br.com.estudante.customerapi.models

import javax.persistence.*

@Entity
@Table
data class Customer (
  @Id
  @GeneratedValue
  val id: Long,
  val name: String,
  val cpf: String
    )
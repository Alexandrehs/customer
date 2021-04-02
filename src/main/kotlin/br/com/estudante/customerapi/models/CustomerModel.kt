package br.com.estudante.customerapi.models

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

@Entity
@Table
data class Customer (
  @Id
  @GeneratedValue
  val id: Long = 0,

  @field:NotBlank(message = "Nome obrigatório")
  val name: String,

  @field:NotBlank(message = "CPF obrigatório")
  @field:Min(11)
  @field:Max(11)
  val cpf: String,

  @field:NotBlank(message = "CEP obrigatório")
  val cep: String,

  @field:NotBlank(message = "E-mail obrigatório")
  @field:Email
  val email: String
)
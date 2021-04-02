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

  @NotBlank(message = "Nome obrigatório")
  val name: String,

  @NotBlank(message = "CPF obrigatório")
  @Min(11)
  @Max(11)
  val cpf: String,

  @NotBlank(message = "CEP obrigatório")
  val cep: String,

  @NotBlank(message = "E-mail obrigatório")
  @Email
  val email: String
)
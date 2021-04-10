package br.com.estudante.customerapi.rest

import org.hibernate.validator.constraints.br.CPF
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Entity
@Table(name = "customers")
data class CustomerRequest (

  @Id
  @GeneratedValue
  val id: Long,

  @field:NotBlank(message = "Nome não pode ficar em branco.", )
  @field:Size(min = 10, max = 50, message = "O nome deve conter entre {min} e {max} letras.")
  val name : String?,

  @field:NotBlank(message = "CPF é obrigátorio.")
  @field:CPF(message = "CPF inválido, confira se os números estão corretos.")
  val personCode : String?,

  @field:NotBlank(message = "Digite um CEP.")
  @field:Pattern(regexp = "^[0-9]{8}", message = "O CEP não é válido.")
  val postalCode : String?,

  @field:NotBlank(message = "Precisamos de um e-mail válido.")
  @field:Email(message = "Digite um e-mail válido por exemplo joao@joao.com")
  val email : String?
)

data class CustomerResponse (
  val id: Long
    )
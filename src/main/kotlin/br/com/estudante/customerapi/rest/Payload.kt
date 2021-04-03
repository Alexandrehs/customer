package br.com.estudante.customerapi.rest

import org.hibernate.validator.constraints.br.CPF
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class CustomerRequest (
  @Id
  val id : Long?,

  @field:NotBlank
  @field:Size(min = 1, max = 50)
  val name : String?,

  @field:NotBlank
  @field:Pattern(regexp = "^[0-9]{11}", message = "Obrigátorio, e deve conter apenas numeros e deve ser válido.")
  @field:CPF
  val personCode : String?,

  @field:NotBlank
  @field:Pattern(regexp = "^[0-9]{8}", message = "Obrigátorio, e deve conter apenas numeros e deve ser valido")
  val postalCode : String?,

  @field:NotBlank
  @field:Email
  val email : String?
)

data class CustomerResponse (
  @Id
  val id: String?
    )
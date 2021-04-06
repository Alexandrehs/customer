package br.com.estudante.customerapi.rest

import org.hibernate.validator.constraints.br.CPF
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class CustomerRequest (

  @field:NotBlank(message = "Desculpe, o nome não pode ficar em branco.", )
  @field:Size(min = 10, max = 50, message = "Desculpe, o nome deve conter no minimo 10 letras.")
  val name : String?,

  @field:NotBlank(message = "Desculpe, este campo é obrigátorio e deve conter um CPF válido.")
  @field:CPF(message = "Desculpe, você digitou um CPF inválido, confira se os números estão corretos.")
  val personCode : String?,

  @field:NotBlank(message = "Desculpe, este campo é obrigátorio e não pode ficar em branco.")
  @field:Pattern(regexp = "^[0-9]{8}", message = "Desculpe, por favor insira um CEP válido.")
  val postalCode : String?,

  @field:NotBlank(message = "Precisamo que você informe um e-mail para podermos validar sua conta.")
  @field:Email(message = "Por favor, digite um e-mail válido por exemplo joao@joao.com")
  val email : String?
)

data class CustomerResponse (
  val id: String?
    )
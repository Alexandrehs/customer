package br.com.estudante.customerapi.exceptions

data class CustomerException(
  val field: String,
  val message: String
)
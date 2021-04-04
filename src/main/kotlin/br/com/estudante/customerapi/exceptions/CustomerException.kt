package br.com.estudante.customerapi.exceptions

import java.lang.RuntimeException

data class CustomerException(
  val field: String?,
  val message: String?
)
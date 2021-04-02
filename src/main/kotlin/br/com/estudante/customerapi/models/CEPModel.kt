package br.com.estudante.customerapi.models

data class CEPModel(

  val cep: String,
  val logradouro: String,
  val complemento: String,
  val bairro: String,
  val localidade : String,
  val uf : String,
  val ibge : String,
  val gia : String,
  val ddd : String,
  val siafi : String
)

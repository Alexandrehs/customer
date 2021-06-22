package br.com.estudante.customerapi.rest

import br.com.estudante.customerapi.entity.CustomerEntity
import br.com.estudante.customerapi.validation.NotEmptyWithoutNull
import br.com.estudante.customerapi.validation.PostalCode
import org.hibernate.validator.constraints.br.CPF
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class CustomerRequest(

    @field:NotBlank(message = "Informe o nome")
    @field:Size(min = 3, max = 50, message = "O nome deve conter entre {min} e {max} caracteres.")
    val name: String?,

    @field:NotNull(message = "Informe um CPF")
    @field:CPF(message = "Deve ser um CPF válido")
    val personCode: String?,

    @field:NotNull(message = "Informe um endereço de email")
    @field:NotEmptyWithoutNull(message = "O email não pode estar vazio")
    @field:Email(message = "Deve ser um email válido")
    val email: String?,

    @field:NotNull(message = "O CEP é obrigatório")
    @PostalCode(onlyNumbers = false)
    val postalCode: String?,


    var road: String?,

    @field:NotNull(message = "É preciso ter um numero")
    @field:Size(min = 1, max = 5)
    var number: String?,

    var district: String?,

    var city: String?,

    var state: String?,

    var complement: String?

)

data class CustomerResponse(
    val id: String
) {
    constructor(customerEntity: CustomerEntity) : this(
        id = customerEntity.id
    )
}

data class AddressResponse (
    val logradouro: String?,
    
    val bairro: String?,

    val localidade: String?,

    val uf: String?,
)

package br.com.estudante.customerapi.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Entity
data class CustomerRequest (
    @Id
    @GeneratedValue
    val id : Long? = 0,

    @field:NotBlank
    @field:Size(min = 1, max = 50)
    val name : String? = "",

    @field:NotBlank
    @field:Pattern(regexp = "^[0-9]{11}", message = "Obrigatorio, e deve conter apenas numeros e deve ser valido.")
    val cpf : String? = "",

    @field:NotBlank
    @field:Pattern(regexp = "^[0-9]{8}", message = "Obrigatorio, e deve conter apenas numeros e deve ser valido")
    val cep : String? = "",

    @field:NotBlank
    @field:Email
    val email : String? = ""
)
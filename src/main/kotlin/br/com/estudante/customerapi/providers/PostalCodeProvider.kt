package br.com.estudante.customerapi.providers

import br.com.estudante.customerapi.rest.Address

interface PostalCodeProvider {
    fun findPostalCode(postalCode: String) : Address
}
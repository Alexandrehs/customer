package br.com.estudante.customerapi.providers

import br.com.estudante.customerapi.rest.AddressResponse

interface PostalCodeProvider {
    fun findPostalCode(postalCode: String) : AddressResponse?
}
package br.com.estudante.customerapi.getCepImplementations

import br.com.estudante.customerapi.providers.PostalCodeProvider
import br.com.estudante.customerapi.rest.AddressResponse
import br.com.estudante.customerapi.services.ServiceForGetCepApiExternal

class ViaCep : PostalCodeProvider {

    override fun findPostalCode(postalCode: String): AddressResponse {
        val serviceForGetCepApiExternal = ServiceForGetCepApiExternal()

        val viacepResponse = serviceForGetCepApiExternal.getRestTemplate().getForObject(
            "https://viacep.com.br/ws/{cep}/json",
            ViacepResponse::class.java,
            postalCode
        )

        return AddressResponse(
            road = viacepResponse!!.logradouro,
            district = viacepResponse!!.bairro,
            city = viacepResponse!!.localidade,
            state = viacepResponse!!.uf
        )
    }
}

data class ViacepResponse (
    val logradouro: String?,
    val bairro: String?,
    val localidade: String?,
    val uf: String?
)
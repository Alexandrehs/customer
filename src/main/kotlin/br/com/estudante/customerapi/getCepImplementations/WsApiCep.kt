package br.com.estudante.customerapi.getCepImplementations

import br.com.estudante.customerapi.providers.PostalCodeProvider
import br.com.estudante.customerapi.rest.AddressResponse
import br.com.estudante.customerapi.sevices.ServiceForGetCepApiExternal

class WsApiCep : PostalCodeProvider {

    override fun findPostalCode(postalCode: String): AddressResponse? {
        val serviceForGetCepApiExternal: ServiceForGetCepApiExternal = ServiceForGetCepApiExternal()

        return serviceForGetCepApiExternal.getRestTemplate().getForObject(
            "https://ws.apicep.com/cep/{cep}.json",
            AddressResponse::class.java,
            postalCode
        )
    }
}
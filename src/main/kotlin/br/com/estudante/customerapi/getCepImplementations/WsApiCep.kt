package br.com.estudante.customerapi.getCepImplementations

import br.com.estudante.customerapi.providers.PostalCodeProvider
import br.com.estudante.customerapi.rest.AddressResponse
import br.com.estudante.customerapi.services.ServiceForGetCepApiExternal
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class WsApiCep : PostalCodeProvider {

    override fun findPostalCode(postalCode: String): AddressResponse {
        try {
            val serviceForGetCepApiExternal = ServiceForGetCepApiExternal()

            val addressResponse = serviceForGetCepApiExternal.getRestTemplate().getForObject(
                "https://ws.apicep.com/cep/{cep}.json",
                WSAddressResponse::class.java,
                postalCode
            )

            return AddressResponse(
                road = addressResponse!!.address,
                district = addressResponse!!.district,
                city = addressResponse!!.city,
                state = addressResponse!!.state
            )
        } catch (error: ResponseStatusException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Algo de errado não esta certo!!!", error)
        }
    }
}

data class WSAddressResponse (
    val address: String,
    val district: String,
    val city: String,
    val state: String,
)
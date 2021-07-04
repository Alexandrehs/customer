package br.com.estudante.customerapi.clients

import br.com.estudante.customerapi.providers.PostalCodeProvider
import br.com.estudante.customerapi.rest.Address
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.server.ResponseStatusException

@Component
class WsApiCep : PostalCodeProvider {

    @Autowired
    private lateinit var restTemplate: RestTemplate

    override fun findPostalCode(postalCode: String): Address {
        try {

            val addressResponse = restTemplate.getForObject(
                "https://ws.apicep.com/cep/{cep}.json",
                WSAddressResponse::class.java,
                postalCode
            )

            return Address(
                road = addressResponse!!.address,
                district = addressResponse.district,
                city = addressResponse.city,
                state = addressResponse.state
            )
        } catch (error: ResponseStatusException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Algo de errado não esta certo!!!", error)
        }
    }
}

data class WSAddressResponse(
    val address: String?,
    val district: String?,
    val city: String?,
    val state: String?,
)

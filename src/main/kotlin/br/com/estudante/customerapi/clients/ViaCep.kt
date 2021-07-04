package br.com.estudante.customerapi.clients

import br.com.estudante.customerapi.providers.PostalCodeProvider
import br.com.estudante.customerapi.rest.Address
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.server.ResponseStatusException

@Component
class ViaCep : PostalCodeProvider {

    @Autowired
    private lateinit var restTemplate: RestTemplate

    @Value("\${app.client.services.via-cep}")
    private lateinit var url: String

    override fun findPostalCode(postalCode: String): Address {
        try {

            val viacepResponse = restTemplate.getForObject(
                url,
                ViacepResponse::class.java,
                postalCode
            )

            return Address(
                road = viacepResponse!!.logradouro,
                district = viacepResponse.bairro,
                city = viacepResponse.localidade,
                state = viacepResponse.uf
            )
        } catch (error: ResponseStatusException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Algo de errado não está certo!!!", error)
        }
    }
}

data class ViacepResponse(
    val logradouro: String?,
    val bairro: String?,
    val localidade: String?,
    val uf: String?
)
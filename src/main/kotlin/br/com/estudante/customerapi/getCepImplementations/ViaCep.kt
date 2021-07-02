package br.com.estudante.customerapi.getCepImplementations

import br.com.estudante.customerapi.providers.PostalCodeProvider
import br.com.estudante.customerapi.rest.AddressResponse
import br.com.estudante.customerapi.services.ServiceForGetCepApiExternal
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class ViaCep : PostalCodeProvider {

    override fun findPostalCode(postalCode: String): AddressResponse {
        try {
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
        } catch(error: ResponseStatusException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Algo de errado não está certo!!!", error)
        }
    }
}

data class ViacepResponse (
    val logradouro: String?,
    val bairro: String?,
    val localidade: String?,
    val uf: String?
)
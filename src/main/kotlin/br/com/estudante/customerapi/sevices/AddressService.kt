package br.com.estudante.customerapi.sevices

import br.com.estudante.customerapi.rest.AddressResponse
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class AddressService {
    fun getAddress(postalCode: String?): AddressResponse? {
        try {
            return RestTemplate().getForObject(
                "https://viacep.com.br/ws/{cep}/json",
                AddressResponse::class.java,
                postalCode
                )
        } finally {
            return null
        }
    }
}
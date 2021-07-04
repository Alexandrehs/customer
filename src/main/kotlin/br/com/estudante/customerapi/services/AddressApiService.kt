package br.com.estudante.customerapi.services

import br.com.estudante.customerapi.clients.ViaCep
import br.com.estudante.customerapi.clients.WsApiCep
import br.com.estudante.customerapi.rest.Address
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AddressApiService {

    @Autowired
    private lateinit var viaCep: ViaCep

    @Autowired
    private lateinit var wsApiCep: WsApiCep

    fun findCepApi(postalCode: String): Address {
        return try {
            viaCep.findPostalCode(postalCode)
        } catch (exception: Exception) {
            wsApiCep.findPostalCode(postalCode)
        } catch (exception: Exception) {
            throw exception
        }
    }
}
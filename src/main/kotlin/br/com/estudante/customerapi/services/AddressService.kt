package br.com.estudante.customerapi.services

import br.com.estudante.customerapi.enums.ApiExternal
import br.com.estudante.customerapi.factories.AddressFactory
import br.com.estudante.customerapi.rest.AddressResponse
import org.springframework.stereotype.Service

@Service
class AddressService {
    fun getAddress(postalCode: String): AddressResponse {
        val addressFactory = AddressFactory()

        return try {
            val address = addressFactory.makeAddress(ApiExternal.VIACEP)
            address.findPostalCode(postalCode)
        } catch (exception : Exception) {
            val address = addressFactory.makeAddress(ApiExternal.WSAPICEP)
            address.findPostalCode(postalCode)
        } catch (exception: Exception) {
            throw exception
        }
    }
}
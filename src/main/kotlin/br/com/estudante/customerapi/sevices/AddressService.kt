package br.com.estudante.customerapi.sevices

import br.com.estudante.customerapi.factories.AddressFactory
import br.com.estudante.customerapi.rest.AddressResponse
import org.springframework.stereotype.Service

@Service
class AddressService {
    fun getAddress(postalCode: String): AddressResponse? {
        val addressFactory = AddressFactory()
        var address = addressFactory.makeAddress("viacep")

        if(address == null) {
            address = addressFactory.makeAddress("ws")
        }

        return address?.findPostalCode(postalCode)
    }
}
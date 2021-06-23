package br.com.estudante.customerapi.factories

import br.com.estudante.customerapi.getCepImplementations.ViaCep
import br.com.estudante.customerapi.getCepImplementations.WsApiCep
import br.com.estudante.customerapi.providers.PostalCodeProvider

class AddressFactory {

    fun makeAddress(api: String?) : PostalCodeProvider? {
        return when(api) {
            "viacep" -> ViaCep()
            "ws" -> WsApiCep()
            else -> {
                return null
            }
        }
    }
}
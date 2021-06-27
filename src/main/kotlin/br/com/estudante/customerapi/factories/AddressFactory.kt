package br.com.estudante.customerapi.factories

import br.com.estudante.customerapi.enums.ApiExternal
import br.com.estudante.customerapi.getCepImplementations.ViaCep
import br.com.estudante.customerapi.getCepImplementations.WsApiCep
import br.com.estudante.customerapi.providers.PostalCodeProvider
import java.lang.IllegalArgumentException

class AddressFactory {

    fun makeAddress(api: ApiExternal) : PostalCodeProvider {
        return when(api) {
            ApiExternal.VIACEP -> ViaCep()
            ApiExternal.WSAPICEP -> WsApiCep()
            else -> {
                return throw IllegalArgumentException("API is not supported")
            }
        }
    }
}
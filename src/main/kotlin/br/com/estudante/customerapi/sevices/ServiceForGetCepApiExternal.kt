package br.com.estudante.customerapi.sevices

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate

class ServiceForGetCepApiExternal {
//    private fun setTimeOutForReadyAndConnection() : HttpComponentsClientHttpRequestFactory {
//        val clientHttpRequestFactory = HttpComponentsClientHttpRequestFactory()
//
//        clientHttpRequestFactory.setConnectTimeout(15000)
//        clientHttpRequestFactory.setReadTimeout(15000)
//
//        return clientHttpRequestFactory
//    }

    public fun getRestTemplate() : RestTemplate {
        return RestTemplate()
    }
}
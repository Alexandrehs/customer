package br.com.estudante.customerapi.service

import br.com.estudante.customerapi.models.CEPModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class CepService {

  @Autowired
  lateinit var restTemplate: RestTemplate

  fun getCep(cep : String) : CEPModel? {
    return restTemplate.getForObject("http://viacep.com.br/ws/${cep}/json/", CEPModel::class.java)
  }
}
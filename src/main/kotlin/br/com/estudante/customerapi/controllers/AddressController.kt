package br.com.estudante.customerapi.controllers

import br.com.estudante.customerapi.entity.AddressEntity
import br.com.estudante.customerapi.repository.AddressRepository
import br.com.estudante.customerapi.services.AddressService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AddressController {
    @Autowired
    lateinit var addressRepository: AddressRepository

    fun getAddress(postalCode: String) : AddressEntity {
        try {
            val addressFromDatabase = addressRepository.findByPostalCode(postalCode)

            if(addressFromDatabase != null) {
                return addressFromDatabase
            }

            val addressService = AddressService()
            val addressExternalApi = addressService.getAddress(postalCode)
            return addressRepository.save(AddressEntity(
                id = UUID.randomUUID().toString(),
                road = addressExternalApi.road!!,
                district = addressExternalApi.district!!,
                city = addressExternalApi.city!!,
                state = addressExternalApi.state!!,
                postalCode = postalCode
            ))
        } catch (exception: Exception) {
            throw exception
        }
    }
}
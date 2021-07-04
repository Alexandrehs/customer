package br.com.estudante.customerapi.services

import br.com.estudante.customerapi.entity.AddressEntity
import br.com.estudante.customerapi.repository.AddressRepository
import java.util.UUID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AddressService {

    @Autowired
    lateinit var addressRepository: AddressRepository

    @Autowired
    lateinit var addressApiService: AddressApiService

    fun resolveAddress(postalCode: String): AddressEntity {
        try {
            val addressFromDatabase = addressRepository.findByPostalCode(postalCode)

            if (addressFromDatabase != null) {
                return addressFromDatabase
            }

            val addressExternalApi = addressApiService.findCepApi(postalCode)
            return addressRepository.save(AddressEntity(
                street = addressExternalApi.road!!,
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

package br.com.estudante.customerapi.scheduler

import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled

@Configuration
@EnableScheduling
class AddressScheduler {

    @Scheduled(cron = "* * 23 * * * *")
    fun updateAddressData() {

//        Esta é uma abordagem de resolver a questão dos
//        customer que não tem o Id do address.
//
//        Eu te passo mais detalhes por áudio
    }
}

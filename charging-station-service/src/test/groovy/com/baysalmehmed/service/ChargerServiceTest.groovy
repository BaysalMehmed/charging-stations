package com.baysalmehmed.service

import com.baysalmehmed.model.Charger
import com.baysalmehmed.model.dao.ChargerDao
import com.baysalmehmed.repository.ChargerRepository
import spock.lang.Specification

class ChargerServiceTest extends Specification {

    private ChargerRepository chargerRepository = Mock(ChargerRepository)
    private ChargerService chargerService = new ChargerService(chargerRepository)

    def "when charger exists return charger"(){
        given:
            Integer chargerId = 1
            ChargerDao expectedCharger =
                    new ChargerDao("T", "D", 10 , 1, 12, 24);
        when:
            Charger chargerResult = chargerService.getCharger(chargerId)
        then:
            1 * chargerRepository.findById(chargerId) >> Optional.of(expectedCharger)
            chargerResult != null
            0 * _
    }

    def "when charger does not exist return null"(){
        given:
            Integer chargerId = 1
            Optional<ChargerDao> expectedCharger = Optional.empty()
        when:
            Charger chargerResult = chargerService.getCharger(chargerId)
        then:
            1 * chargerRepository.findById(chargerId) >> expectedCharger
            chargerResult == null
            0 * _
    }
}

package com.baysalmehmed.service

import com.baysalmehmed.exception.type.charger.ChargerDoesNotExistException
import com.baysalmehmed.model.dao.ChargerDao
import com.baysalmehmed.model.out.ChargerOut
import com.baysalmehmed.model.out.ChargerTypeOut
import com.baysalmehmed.repository.ChargerRepository
import spock.lang.Specification

class ChargerServiceTest extends Specification {

    private ChargerRepository chargerRepository = Mock(ChargerRepository)
    private ChargerTypeService chargerTypeService = Mock(ChargerTypeService)

    private ChargerService chargerService = new ChargerService(chargerRepository, chargerTypeService)

    List<ChargerTypeOut> defaultChargerTypes = getChargerTypes()

    def "when charger exists return charger"(){
        given:
            Integer chargerId = 1
            ChargerDao expectedCharger =
                    new ChargerDao(1, "D", 10 , 1, 12, 24)
        when:
            ChargerOut chargerResult = chargerService.getCharger(chargerId)
        then:
            1 * chargerTypeService.getChargerTypes() >> defaultChargerTypes
            1 * chargerRepository.findById(chargerId) >> Optional.of(expectedCharger)
            chargerResult != null
            0 * _
    }

    def "when charger does not exist throw ChargerDoesNotExistException"(){
        given:
            Integer chargerId = 1
            Optional<ChargerDao> expectedCharger = Optional.empty()
        when:
            chargerService.getCharger(chargerId)
        then:
            1 * chargerTypeService.getChargerTypes() >> defaultChargerTypes
            1 * chargerRepository.findById(chargerId) >> expectedCharger
            thrown(ChargerDoesNotExistException)
            0 * _
    }

    private static List<ChargerTypeOut> getChargerTypes(){
        return [
                new ChargerTypeOut(1, "Tesla Supercharger"),
                new ChargerTypeOut(2, "CCS"),
                new ChargerTypeOut(3, "Type 2")
        ]
    }
}

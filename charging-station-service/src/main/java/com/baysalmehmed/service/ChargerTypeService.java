package com.baysalmehmed.service;

import com.baysalmehmed.factory.chargerType.ChargerTypeDaoFactory;
import com.baysalmehmed.factory.chargerType.ChargerTypeFactory;
import com.baysalmehmed.model.in.ChargerTypeIn;
import com.baysalmehmed.model.dao.ChargerTypeDao;
import com.baysalmehmed.model.out.ChargerTypeOut;
import com.baysalmehmed.repository.ChargerTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChargerTypeService {

    private ChargerTypeRepository chargerTypeRepository;

    public ChargerTypeService(ChargerTypeRepository chargerRepository) {
        this.chargerTypeRepository = chargerRepository;
    }

    public List<ChargerTypeOut> getChargerTypes(){
        return ChargerTypeFactory.createChargerTypes(chargerTypeRepository.findAll());
    }

    public ChargerTypeOut getChargerType(Integer chargerTypeId){
        Optional<ChargerTypeDao> chargerDao = chargerTypeRepository.findById(chargerTypeId);
        return chargerDao.map(ChargerTypeFactory::createChargerType).orElse(null);
    }

    public ChargerTypeOut createChargerType(ChargerTypeIn newChargerType){
        ChargerTypeDao savedCharger = chargerTypeRepository.save(ChargerTypeDaoFactory.createChargerType(newChargerType));
        return ChargerTypeFactory.createChargerType(savedCharger);
    }

    public void deleteChargerType(Integer chargerTypeId){
        chargerTypeRepository.deleteById(chargerTypeId);
    }
}

package com.baysalmehmed.service;

import com.baysalmehmed.exception.type.charger.ChargerDoesNotExistException;
import com.baysalmehmed.exception.type.chargerType.ChargerTypeDidNotSaveException;
import com.baysalmehmed.exception.type.chargerType.ChargerTypeDoesNotExistException;
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
        List<ChargerTypeDao> chargerTypesList = chargerTypeRepository.findAll();
        if(chargerTypesList.size() > 0){
            return ChargerTypeFactory.createChargerTypes(chargerTypesList);
        } else{
            throw new ChargerDoesNotExistException();
        }
    }

    public ChargerTypeOut getChargerType(Integer chargerTypeId){
        Optional<ChargerTypeDao> chargerDao = chargerTypeRepository.findById(chargerTypeId);
        if (chargerDao.isPresent()) {
            return ChargerTypeFactory.createChargerType(chargerDao.get());
        } else {
            throw new ChargerTypeDoesNotExistException(chargerTypeId);
        }
    }

    public ChargerTypeOut createChargerType(ChargerTypeIn newChargerType){
        ChargerTypeDao savedChargerType;
        try {
            savedChargerType = chargerTypeRepository.save(ChargerTypeDaoFactory.createChargerType(newChargerType));
        } catch (Exception e){
            throw new ChargerTypeDidNotSaveException(e.getMessage());
        }
        return ChargerTypeFactory.createChargerType(savedChargerType);
    }

    public void deleteChargerType(Integer chargerTypeId){
        chargerTypeRepository.deleteById(chargerTypeId);
    }
}

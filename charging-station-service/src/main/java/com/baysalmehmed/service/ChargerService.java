package com.baysalmehmed.service;

import com.baysalmehmed.factory.charger.ChargerDaoFactory;
import com.baysalmehmed.factory.charger.ChargerFactory;
import com.baysalmehmed.model.dao.ChargerDao;
import com.baysalmehmed.model.dao.ChargerTypeDao;
import com.baysalmehmed.model.in.ChargerIn;
import com.baysalmehmed.model.out.ChargerOut;
import com.baysalmehmed.repository.ChargerRepository;
import com.baysalmehmed.repository.ChargerTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChargerService {

    private ChargerRepository chargerRepository;
    private List<ChargerTypeDao> chargerTypeDaos;

    public ChargerService(ChargerRepository chargerRepository, ChargerTypeRepository chargerTypeRepository) {
        this.chargerRepository = chargerRepository;
        this.chargerTypeDaos = chargerTypeRepository.findAll();
    }

    public List<ChargerOut> getChargers(){
        return ChargerFactory.createChargers(chargerRepository.findAll(), chargerTypeDaos);
    }

    public ChargerOut getCharger(Integer chargerId){
        ChargerOut chargerOut = null;
        Optional<ChargerDao> chargerDao = chargerRepository.findById(chargerId);
        if(chargerDao.isPresent()) {
            chargerOut = ChargerFactory.createCharger(chargerDao.get(), chargerTypeDaos);
        }
        return chargerOut;
    }

    public ChargerOut createCharger(ChargerIn newCharger){
        ChargerDao savedCharger = chargerRepository.save(ChargerDaoFactory.createCharger(newCharger));
        return ChargerFactory.createCharger(savedCharger, chargerTypeDaos);
    }

    public void deleteCharger(Integer chargerId){
        chargerRepository.deleteById(chargerId);
    }
}

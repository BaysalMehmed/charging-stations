package com.baysalmehmed.service;

import com.baysalmehmed.factory.ChargerDaoFactory;
import com.baysalmehmed.factory.ChargerFactory;
import com.baysalmehmed.model.Charger;
import com.baysalmehmed.model.dao.ChargerDao;
import com.baysalmehmed.repository.ChargerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChargerService {

    private ChargerRepository chargerRepository;

    public ChargerService(ChargerRepository chargerRepository) {
        this.chargerRepository = chargerRepository;
    }

    public List<Charger> getChargers(){
        return ChargerFactory.createChargers(chargerRepository.findAll());
    }

    public Charger getCharger(Integer chargerId){
        Optional<ChargerDao> chargerDao = chargerRepository.findById(chargerId);
        return chargerDao.map(ChargerFactory::createCharger).orElse(null);
    }

    public Integer createCharger(Charger newCharger){
        ChargerDao savedCharger = chargerRepository.save(ChargerDaoFactory.createCharger(newCharger));
        return savedCharger.id;
    }

    public void deleteCharger(Integer chargerId){
        chargerRepository.deleteById(chargerId);
    }
}

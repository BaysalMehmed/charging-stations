package com.baysalmehmed.factory;

import com.baysalmehmed.model.Charger;
import com.baysalmehmed.model.Location;
import com.baysalmehmed.model.dao.ChargerDao;

import java.util.List;
import java.util.stream.Collectors;

public class ChargerFactory{

    public static Charger createCharger(ChargerDao chargerDao) {
        return new Charger(
                new Location(chargerDao.latitude, chargerDao.longitude),
                chargerDao.description,
                chargerDao.type,
                chargerDao.totalSpaces,
                chargerDao.usedSpaces);
    }

    public static List<Charger> createChargers(List<ChargerDao> chargerDaos) {
        return chargerDaos.stream().map(ChargerFactory::createCharger).collect(Collectors.toList());
    }
}

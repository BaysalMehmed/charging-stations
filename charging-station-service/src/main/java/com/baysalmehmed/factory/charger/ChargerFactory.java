package com.baysalmehmed.factory.charger;

import com.baysalmehmed.model.Location;
import com.baysalmehmed.model.dao.ChargerDao;
import com.baysalmehmed.model.dao.ChargerTypeDao;
import com.baysalmehmed.model.out.ChargerOut;

import java.util.List;
import java.util.stream.Collectors;

public class ChargerFactory{

    public static ChargerOut createCharger(ChargerDao chargerDao, List<ChargerTypeDao> chargerTypeDao) {
        return new ChargerOut(chargerDao.id,
                new Location(chargerDao.latitude, chargerDao.longitude),
                chargerDao.description,
                chargerTypeDao.stream().filter(chargerType -> chargerType.id.equals(chargerDao.type)).findFirst().get().type ,
                chargerDao.totalSpaces,
                chargerDao.usedSpaces);
    }

    public static List<ChargerOut> createChargers(List<ChargerDao> chargerDaos, List<ChargerTypeDao> chargerTypeDao) {
        return chargerDaos.stream().map(charger -> createCharger(charger, chargerTypeDao)).collect(Collectors.toList());
    }
}

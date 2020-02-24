package com.baysalmehmed.factory.chargerType;

import com.baysalmehmed.model.dao.ChargerTypeDao;
import com.baysalmehmed.model.out.ChargerTypeOut;

import java.util.List;
import java.util.stream.Collectors;

public class ChargerTypeFactory{

    public static ChargerTypeOut createChargerType(ChargerTypeDao chargerDao) {
        return new ChargerTypeOut(chargerDao.id, chargerDao.type);
    }

    public static List<ChargerTypeOut> createChargerTypes(List<ChargerTypeDao> chargerDaos) {
        return chargerDaos.stream().map(ChargerTypeFactory::createChargerType).collect(Collectors.toList());
    }
}

package com.baysalmehmed.factory;

import com.baysalmehmed.model.Charger;
import com.baysalmehmed.model.dao.ChargerDao;

import java.util.List;
import java.util.stream.Collectors;

public class ChargerDaoFactory {

    public static ChargerDao createCharger(Charger charger) {
        return new ChargerDao(
                charger.type,
                charger.description,
                charger.totalSpaces,
                charger.usedSpaces,
                charger.location.longitude,
                charger.location.latitude);
    }

    public static List<ChargerDao> createChargers(List<Charger> charger) {
        return charger.stream().map(ChargerDaoFactory::createCharger).collect(Collectors.toList());
    }
}

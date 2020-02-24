package com.baysalmehmed.factory.charger;

import com.baysalmehmed.model.dao.ChargerDao;
import com.baysalmehmed.model.in.ChargerIn;

import java.util.List;
import java.util.stream.Collectors;

public class ChargerDaoFactory {

    public static ChargerDao createCharger(ChargerIn charger) {
        return new ChargerDao(
                charger.type,
                charger.description,
                charger.totalSpaces,
                charger.usedSpaces,
                charger.location.longitude,
                charger.location.latitude);
    }

    public static List<ChargerDao> createChargers(List<ChargerIn> charger) {
        return charger.stream().map(ChargerDaoFactory::createCharger).collect(Collectors.toList());
    }
}

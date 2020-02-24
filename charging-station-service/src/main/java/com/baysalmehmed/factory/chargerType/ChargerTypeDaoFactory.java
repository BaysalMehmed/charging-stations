package com.baysalmehmed.factory.chargerType;

import com.baysalmehmed.model.dao.ChargerTypeDao;
import com.baysalmehmed.model.in.ChargerTypeIn;

import java.util.List;
import java.util.stream.Collectors;

public class ChargerTypeDaoFactory {

    public static ChargerTypeDao createChargerType(ChargerTypeIn charger) {
        return new ChargerTypeDao(charger.type);
    }

    public static List<ChargerTypeDao> createChargers(List<ChargerTypeIn> charger) {
        return charger.stream().map(ChargerTypeDaoFactory::createChargerType).collect(Collectors.toList());
    }
}

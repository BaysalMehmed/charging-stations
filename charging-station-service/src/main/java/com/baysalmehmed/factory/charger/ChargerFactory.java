package com.baysalmehmed.factory.charger;

import com.baysalmehmed.exception.type.chargerType.ChargerTypeDoesNotExistException;
import com.baysalmehmed.model.Location;
import com.baysalmehmed.model.dao.ChargerDao;
import com.baysalmehmed.model.out.ChargerOut;
import com.baysalmehmed.model.out.ChargerTypeOut;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ChargerFactory{

    public static ChargerOut createCharger(ChargerDao chargerDao, List<ChargerTypeOut> chargerTypes) {

        Optional<ChargerTypeOut> chargerTypeOut = chargerTypes.stream().filter(chargerType -> chargerType.id.equals(chargerDao.type)).findFirst();
        if(chargerTypeOut.isPresent()){
            return new ChargerOut(chargerDao.id,
                    new Location(chargerDao.latitude, chargerDao.longitude),
                    chargerDao.description,
                     chargerTypeOut.get().type,
                    chargerDao.totalSpaces,
                    chargerDao.usedSpaces);
        } else {
            throw new ChargerTypeDoesNotExistException(chargerDao.type);
        }
    }

    public static List<ChargerOut> createChargers(List<ChargerDao> chargerDaos, List<ChargerTypeOut> chargerTypeDao) {
        return chargerDaos.stream().map(charger -> createCharger(charger, chargerTypeDao)).collect(Collectors.toList());
    }
}

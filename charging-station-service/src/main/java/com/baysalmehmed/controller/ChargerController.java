package com.baysalmehmed.controller;

import com.baysalmehmed.model.in.ChargerIn;
import com.baysalmehmed.model.out.ChargerOut;
import com.baysalmehmed.service.ChargerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChargerController {

    private ChargerService chargerService;

    public ChargerController(ChargerService chargerService) {
        this.chargerService = chargerService;
    }

    @RequestMapping("/chargers")
    public List<ChargerOut> getAllChargers(
            @RequestParam(name = "latitude", required = false) Double latitude,
            @RequestParam(name = "longitude", required = false) Double longitude,
            @RequestParam(name = "miles", required = false) Double miles){
        return chargerService.getChargers(latitude, longitude, miles);
    }

    @RequestMapping("/charger")
    public ChargerOut getChargerById(@RequestParam(name = "id") Integer id){
        return chargerService.getCharger(id);
    }

    @PostMapping("/charger/add")
    public ChargerOut createNewCharger(@RequestBody ChargerIn newCharger){
        return chargerService.createCharger(newCharger);
    }

    @DeleteMapping("/charger/delete")
    public void deleteChargerById(@RequestParam(name = "id") Integer id){
        chargerService.deleteCharger(id);
    }
}

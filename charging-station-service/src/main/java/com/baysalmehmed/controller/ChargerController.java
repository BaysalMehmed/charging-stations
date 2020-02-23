package com.baysalmehmed.controller;

import com.baysalmehmed.model.Charger;
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
    public List<Charger> getAllChargers(){
        return chargerService.getChargers();
    }

    @RequestMapping("/charger")
    public Charger getChargerById(@RequestParam(name = "id") Integer id){
        return chargerService.getCharger(id);
    }

    @PostMapping("/charger/add")
    public Integer createNewCharger(@RequestBody Charger newCharger){
        return chargerService.createCharger(newCharger);
    }

    @DeleteMapping("/charger/delete")
    public void deleteChargerById(@RequestParam(name = "id") Integer id){
        chargerService.deleteCharger(id);
    }
}

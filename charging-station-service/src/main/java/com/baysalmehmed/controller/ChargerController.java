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
    public List<ChargerOut> getAllChargers(){
        return chargerService.getChargers();
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

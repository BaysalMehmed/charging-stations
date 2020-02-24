package com.baysalmehmed.controller;

import com.baysalmehmed.model.in.ChargerTypeIn;
import com.baysalmehmed.model.out.ChargerTypeOut;
import com.baysalmehmed.service.ChargerTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChargerTypeController {

    private ChargerTypeService chargerTypeService;

    public ChargerTypeController(ChargerTypeService chargerTypeService) {
        this.chargerTypeService = chargerTypeService;
    }

    @RequestMapping("/charger/types")
    public List<ChargerTypeOut> getAllChargerTypes(){
        return chargerTypeService.getChargerTypes();
    }

    @RequestMapping("/charger/type")
    public ChargerTypeOut getChargerTypeById(@RequestParam(name = "id") Integer id){
        return chargerTypeService.getChargerType(id);
    }

    @PostMapping("/charger/type/add")
    public ChargerTypeOut createNewChargerType(@RequestBody ChargerTypeIn newChargerType){
        return chargerTypeService.createChargerType(newChargerType);
    }

    @DeleteMapping("/charger/type/delete")
    public void deleteChargerTypeById(@RequestParam(name = "id") Integer id){
        chargerTypeService.deleteChargerType(id);
    }
}

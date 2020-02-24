package com.baysalmehmed.model;

public class ChargerType {

    public Integer id;
    public String type;

    public ChargerType(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public ChargerType(String type) {
        this.type = type;
    }
}

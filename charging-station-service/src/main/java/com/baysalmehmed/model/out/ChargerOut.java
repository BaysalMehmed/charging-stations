package com.baysalmehmed.model.out;

import com.baysalmehmed.model.Location;

public class ChargerOut {

    public Integer id;
    public Location location;
    public String description;
    public String type;
    public Integer totalSpaces;
    public Integer usedSpaces;

    public ChargerOut(Integer id, Location location, String description, String type, Integer totalSpaces, Integer usedSpaces) {
        this.id = id;
        this.location = location;
        this.description = description;
        this.type = type;
        this.totalSpaces = totalSpaces;
        this.usedSpaces = usedSpaces;
    }
}

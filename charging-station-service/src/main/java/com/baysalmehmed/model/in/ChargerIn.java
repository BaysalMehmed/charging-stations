package com.baysalmehmed.model.in;

import com.baysalmehmed.model.Location;

public class ChargerIn {

    public Location location;
    public String description;
    public Integer type;
    public Integer totalSpaces;
    public Integer usedSpaces;

    public ChargerIn(Location location, String description, Integer type, Integer totalSpaces, Integer usedSpaces) {
        this.location = location;
        this.description = description;
        this.type = type;
        this.totalSpaces = totalSpaces;
        this.usedSpaces = usedSpaces;
    }
}

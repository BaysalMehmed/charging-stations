package com.baysalmehmed.model;

public class Charger {

    public Location location;
    public String description;
    public String type;
    public int totalSpaces;
    public int usedSpaces;

    public Charger(Location location, String description, String type, int totalSpaces, int usedSpaces) {
        this.location = location;
        this.description = description;
        this.type = type;
        this.totalSpaces = totalSpaces;
        this.usedSpaces = usedSpaces;
    }
}

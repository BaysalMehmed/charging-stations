package com.baysalmehmed.exception.type.charger;

public class ChargerDoesNotExistException extends RuntimeException {

    public ChargerDoesNotExistException(Integer id) {
        super(String.format("Charger with ID %s does not exist", id.toString()));
    }

    public ChargerDoesNotExistException() {
        super("No chargers exist");
    }
}

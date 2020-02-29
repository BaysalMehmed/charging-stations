package com.baysalmehmed.exception.type.chargerType;

public class ChargerTypeDoesNotExistException extends RuntimeException {

    public ChargerTypeDoesNotExistException(Integer id) {
        super(String.format("Charger Type with ID %s does not exist", id.toString()));
    }

    public ChargerTypeDoesNotExistException() {
        super("No charger types exist");
    }
}

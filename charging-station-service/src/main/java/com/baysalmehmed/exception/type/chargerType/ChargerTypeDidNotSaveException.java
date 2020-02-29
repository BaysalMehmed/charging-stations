package com.baysalmehmed.exception.type.chargerType;

public class ChargerTypeDidNotSaveException extends RuntimeException {

    public ChargerTypeDidNotSaveException(String exception) {
        super("Failed to create charger type: " + exception);
    }
}

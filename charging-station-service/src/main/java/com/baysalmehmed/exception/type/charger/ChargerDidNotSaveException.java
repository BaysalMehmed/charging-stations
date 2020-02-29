package com.baysalmehmed.exception.type.charger;

public class ChargerDidNotSaveException extends RuntimeException {

    public ChargerDidNotSaveException(String exception) {
        super("Failed to create charger: " + exception);
    }
}

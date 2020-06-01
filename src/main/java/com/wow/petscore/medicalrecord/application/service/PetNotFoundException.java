package com.wow.petscore.medicalrecord.application.service;

public  class PetNotFoundException extends RuntimeException {

    private final String errorCode;
    private final String errorMessage;

    public PetNotFoundException(String errorCode, String errorMessage) {
        super(errorMessage);

        this.errorCode    = errorCode;
        this.errorMessage = errorMessage;
    }

    public String errorCode() {
        return errorCode;
    }

    public String errorMessage() {
        return errorMessage;
    }
}

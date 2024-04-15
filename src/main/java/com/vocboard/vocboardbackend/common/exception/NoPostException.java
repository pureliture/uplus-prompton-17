package com.vocboard.vocboardbackend.common.exception;

public class NoPostException extends RuntimeException {

    public NoPostException(String message) {
        super(message);
    }

    public NoPostException(NoPostException noContentsException) {
        super(noContentsException.getMessage());
    }
}

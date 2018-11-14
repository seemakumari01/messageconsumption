package com.messageconsumption.exceptions;

/**
 * @author Seema
 */
public class InvalidTokenException extends RecoverableException {


    public InvalidTokenException(String message, Throwable throwable) {
        super(message, throwable);
    }

}

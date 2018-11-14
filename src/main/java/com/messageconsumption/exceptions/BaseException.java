package com.messageconsumption.exceptions;

/**
 * @author Seema
 */
public class BaseException extends RuntimeException {
    /**
     * @implNote Empty Constructor
     */
    public BaseException() {
    }

    /**
     * @param message : message
     * @implNote Constructor One Parameter Pass
     */
    public BaseException(String message) {
        super(message);
    }

    /**
     * @param message   : message
     * @param throwable : throwable
     * @implNote Two parameter pass constructor
     */
    public BaseException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * @param throwable : throwable
     * @implNote Constructor pass in Throwable class object
     */
    public BaseException(Throwable throwable) {
        super(throwable);
    }

}
package com.messageconsumption.exceptions;

/**
 * @author Seema
 */
public class InitializationException extends UnrecoverableException {
    /**
     * @implNote Empty Constructor
     */
    public InitializationException() {
        super();
    }

    /**
     * @param message : message
     * @implNote One parameter pass constructor
     */
    public InitializationException(String message) {
        super(message);
    }

    /**
     * @param message   : message
     * @param throwable : throwable
     * @implNote Two Parameter Pass Constructor
     */
    public InitializationException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * @param throwable : throwable
     * @implNote Constructor in pass Throwable class object
     */
    public InitializationException(Throwable throwable) {
        super(throwable);
    }
}

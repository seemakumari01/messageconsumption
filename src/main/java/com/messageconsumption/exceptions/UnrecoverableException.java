package com.messageconsumption.exceptions;

/**
 * @author Seema
 */
public class UnrecoverableException extends BaseException {

    /**
     * @implNote Empty Constructor
     */
    public UnrecoverableException() {
        super();
    }

    /**
     * @param message : message
     * @implNote : One Parameter pass constructor
     */
    public UnrecoverableException(String message) {
        super(message);
    }

    /**
     * @param message   : message
     * @param throwable : throwable
     * @implNote Two parameter pass constructor
     */
    public UnrecoverableException(String message, Throwable throwable) {
        super(message, throwable);
    }


    /**
     * @param throwable : throwable
     * @implNote Constructor in pass Throwable class object
     */
    public UnrecoverableException(Throwable throwable) {
        super(throwable);
    }
}

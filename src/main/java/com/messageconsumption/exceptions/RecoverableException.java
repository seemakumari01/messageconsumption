package com.messageconsumption.exceptions;

/**
 * @author Seema
 */
public class RecoverableException extends BaseException {

    /**
     * @param message   : message
     * @param throwable : throwable
     * @implNote Two Parameter pass constructor
     */
    public RecoverableException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * @implNote Empty Constructor
     */
    public RecoverableException() {
        super();
    }

    /**
     * @param message : message
     * @implNote One Parameter pass Constructor
     */
    public RecoverableException(String message) {
        super(message);
    }

    /**
     * @param throwable : throwable
     * @implNote Constructor in pass Throwable class object
     */
    public RecoverableException(Throwable throwable) {
        super(throwable);
    }


}

package com.messageconsumption.exceptions;

/**
 * Database CRUD Exception class
 * @author Seema
 */
public class DatabaseOperationException extends RecoverableException {
    /**
     * @implNote Empty Constructor
     */
    public DatabaseOperationException() {
    }

    /**
     * @param message : message
     * @implNote One Parameter pass Constructor
     */
    public DatabaseOperationException(String message) {
        super(message);
    }

    /**
     * Two parameter pass constructor
     *
     * @param throwable : throwable
     * @implNote message
     */
    public DatabaseOperationException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * @param throwable : throwable
     * @implNote Constructor Pass in Throwable class object
     */
    public DatabaseOperationException(Throwable throwable) {
        super(throwable);
    }
}


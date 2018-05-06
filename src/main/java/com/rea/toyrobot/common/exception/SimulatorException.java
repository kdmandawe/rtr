package com.rea.toyrobot.common.exception;

/**
 * Generic custom application runtime exception
 */
public class SimulatorException extends RuntimeException {

    /**
     * Instantiates a new Simulator exception.
     *
     * @param message the error message
     */
    public SimulatorException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Simulator exception.
     *
     * @param message the error message
     * @param cause   the parent error
     */
    public SimulatorException(String message, Throwable cause) {
        super(message, cause);
    }

}

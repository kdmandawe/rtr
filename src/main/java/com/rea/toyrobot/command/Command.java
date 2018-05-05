package com.rea.toyrobot.command;

/**
 * Interface which should be implemented by Concrete Robot Commands
 */
public interface Command {
    /**
     * Executes the command
     */
    void perform();
}

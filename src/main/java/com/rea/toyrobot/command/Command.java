package com.rea.toyrobot.command;

/**
 * Interface which should be implemented by Concrete Robot Commands
 */
public interface Command {
    /**
     * Executes the command and delegates the toy robot to perform the actual action
     */
    void perform();
}

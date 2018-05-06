package com.rea.toyrobot.input;

import com.rea.toyrobot.command.Command;
import com.rea.toyrobot.robot.ToyRobot;

import java.util.List;
import java.util.Optional;

/**
 * This is the interface for handling input of Commands
 * Implementation may handle input coming from file, CLI, etc.
 */
public interface InputHandler {
    /**
     * Gets commands from client input.
     *
     * @param inputArgs the input arguments provided by the client
     * @param robot     the toy robot where the commands will be fed for executions
     * @return the commands as {@link Optional} as this may not contain any commands at all
     */
    Optional<List<Command>> getCommands(String[] inputArgs, ToyRobot robot);
}

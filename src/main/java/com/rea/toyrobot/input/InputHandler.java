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
    Optional<List<Command>> getCommands(String[] inputArgs, ToyRobot robot);
}

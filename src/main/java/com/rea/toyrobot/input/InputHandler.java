package com.rea.toyrobot.input;

import com.rea.toyrobot.command.Command;

import java.util.List;

/**
 * This is the interface for handling input of Commands
 * Implementation may handle input coming from file, CLI, etc.
 */
public interface InputHandler {
    List<Command> getCommands(String[] inputArgs);
}

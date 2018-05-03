package com.rea.toyrobot.input;

import com.rea.toyrobot.command.Command;
import com.rea.toyrobot.robot.ToyRobot;

import java.util.List;
import java.util.Optional;

/**
 * A {@link InputHandler} implementation smart enough to determine if input is coming
 * from a file or from stdIn
 */
public class SmartInputHandler implements InputHandler {

    @Override
    public Optional<List<Command>> getCommands(String[] inputArgs, ToyRobot toyRobot) {
        Optional<List<Command>> commands = Optional.empty();
        if(inputArgs != null && inputArgs.length  == 1) {
            InputHandler handler = new FileInputHandler();
            commands = handler.getCommands(inputArgs, toyRobot);
        } else {
            //TODO stdIn
        }
        return commands;
    }
}

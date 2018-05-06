package com.rea.toyrobot.command;

import com.rea.toyrobot.robot.ToyRobot;
import com.rea.toyrobot.robot.TurnDirection;

/**
 * This class represents a Left Command which will be a result of parsing the 'LEFT'
 * raw command input
 */
public class LeftCommand implements Command {

    private final ToyRobot toyRobot;

    /**
     * Instantiates a new Left command.
     *
     * @param toyRobot the toy robot which will perform the actual action
     */
    LeftCommand(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void perform() {
        toyRobot.doTurn(TurnDirection.LEFT);
    }

    @Override
    public String toString() {
        return "LeftCommand{" +
                "toyRobot=" + toyRobot +
                '}';
    }
}

package com.rea.toyrobot.command;

import com.rea.toyrobot.robot.ToyRobot;

/**
 * This class represents a Move Command which will be a result of parsing the 'MOVE'
 * raw command input
 */
public class MoveCommand implements Command {

    private final ToyRobot toyRobot;

    /**
     * Instantiates a new Move command.
     *
     * @param toyRobot the toy robot which will perform the actual action
     */
    MoveCommand(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void perform() {
        toyRobot.doMove();
    }

    @Override
    public String toString() {
        return "MoveCommand{" +
                "toyRobot=" + toyRobot +
                '}';
    }
}

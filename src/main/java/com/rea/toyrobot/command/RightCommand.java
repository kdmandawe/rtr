package com.rea.toyrobot.command;

import com.rea.toyrobot.robot.ToyRobot;
import com.rea.toyrobot.robot.TurnDirection;

/**
 * This class represents a Right Command which will be a result of parsing the 'RIGHT'
 * raw command input
 */
public class RightCommand implements Command {

    private final ToyRobot toyRobot;

    /**
     * Instantiates a new Right command.
     *
     * @param toyRobot the toy robot which will perform the actual action
     */
    RightCommand(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void perform() {
        toyRobot.doTurn(TurnDirection.RIGHT);
    }

    @Override
    public String toString() {
        return "RightCommand{" +
                "toyRobot=" + toyRobot +
                '}';
    }
}

package com.rea.toyrobot.command;

import com.rea.toyrobot.robot.ToyRobot;
import com.rea.toyrobot.robot.TurnDirection;

/**
 * This class represents a LeftCommand which will be a result of parsing the 'LEFT'
 * raw command input
 */
public class LeftCommand implements Command {

    private ToyRobot toyRobot;

    LeftCommand(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }

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

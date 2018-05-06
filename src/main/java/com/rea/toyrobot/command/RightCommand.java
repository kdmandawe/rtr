package com.rea.toyrobot.command;

import com.rea.toyrobot.robot.ToyRobot;
import com.rea.toyrobot.robot.TurnDirection;

public class RightCommand implements Command {

    private final ToyRobot toyRobot;

    RightCommand(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }

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

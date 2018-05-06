package com.rea.toyrobot.command;

import com.rea.toyrobot.robot.ToyRobot;

public class MoveCommand implements Command {

    private final ToyRobot toyRobot;

    MoveCommand(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }

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

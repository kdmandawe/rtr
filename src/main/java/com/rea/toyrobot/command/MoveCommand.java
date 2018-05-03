package com.rea.toyrobot.command;

import com.rea.toyrobot.robot.ToyRobot;

public class MoveCommand implements Command {

    private ToyRobot toyRobot;

    public MoveCommand(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }

    @Override
    public void perform() {
        //TODO
    }

    @Override
    public String toString() {
        return "MoveCommand{" +
                "toyRobot=" + toyRobot +
                '}';
    }
}

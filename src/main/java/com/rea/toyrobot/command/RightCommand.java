package com.rea.toyrobot.command;

import com.rea.toyrobot.robot.ToyRobot;

public class RightCommand implements Command {

    private ToyRobot toyRobot;

    public RightCommand(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }

    @Override
    public void perform() {
        //TODO
    }

    @Override
    public String toString() {
        return "RightCommand{" +
                "toyRobot=" + toyRobot +
                '}';
    }
}
package com.rea.toyrobot.command;

import com.rea.toyrobot.robot.ToyRobot;

public class LeftCommand implements Command {

    private ToyRobot toyRobot;

    public LeftCommand(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }

    @Override
    public void perform() {
        //TODO
    }

    @Override
    public String toString() {
        return "LeftCommand{" +
                "toyRobot=" + toyRobot +
                '}';
    }
}

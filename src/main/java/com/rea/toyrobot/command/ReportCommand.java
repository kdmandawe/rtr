package com.rea.toyrobot.command;

import com.rea.toyrobot.robot.ToyRobot;

public class ReportCommand implements Command {

    private ToyRobot toyRobot;

    public ReportCommand(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }

    @Override
    public void perform() {
        //TODO
    }

    @Override
    public String toString() {
        return "ReportCommand{" +
                "toyRobot=" + toyRobot +
                '}';
    }
}

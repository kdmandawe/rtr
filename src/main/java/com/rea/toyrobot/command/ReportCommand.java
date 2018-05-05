package com.rea.toyrobot.command;

import com.rea.toyrobot.robot.ToyRobot;

public class ReportCommand implements Command {

    private ToyRobot toyRobot;

    ReportCommand(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }

    @Override
    public void perform() {
        toyRobot.doReport();
    }

    @Override
    public String toString() {
        return "ReportCommand{" +
                "toyRobot=" + toyRobot +
                '}';
    }
}

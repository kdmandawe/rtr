package com.rea.toyrobot.command;

import com.rea.toyrobot.robot.ToyRobot;

/**
 * This class represents a Report Command which will be a result of parsing the 'REPORT'
 * raw command input
 */
public class ReportCommand implements Command {

    private final ToyRobot toyRobot;

    /**
     * Instantiates a new Report command.
     *
     * @param toyRobot the toy robot which will perform the actual action
     */
    ReportCommand(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
    }


    /**
     * {@inheritDoc}
     */
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

package com.rea.toyrobot.simulator;

import com.rea.toyrobot.command.Command;
import com.rea.toyrobot.input.InputHandler;
import com.rea.toyrobot.robot.ToyRobot;
import com.rea.toyrobot.state.State;
import com.rea.toyrobot.tabletop.TableTop;

import java.util.List;
import java.util.Optional;

/**
 * Represents the whole ToyRobot Simulator which can read in commands and transmit
 * those to the ToyRobot which in turn performs the commands on the assigned TableTop.
 * In addition, this simulator can give report on the current status of the ToyRobot.
 */
public final class ToyRobotSimulator {

    private final InputHandler inputHandler;
    private final ToyRobot toyRobot;
    private final TableTop tableTop;

    public ToyRobotSimulator(InputHandler inputHandler, ToyRobot toyRobot, TableTop tableTop) {
        this.inputHandler = inputHandler;
        this.toyRobot = toyRobot;
        this.tableTop = tableTop;
    }

    public void runSimulator(String[] args) {
        Optional<List<Command>> commandList = inputHandler.getCommands(args, this.toyRobot);
    }

    public String getReportString() {
        String ret = null;
        State currentState = this.toyRobot.getState();
        if(currentState != null) {
            ret =  currentState.toString();
        }
        return ret;
    }
}

package com.rea.toyrobot;

import com.rea.toyrobot.command.Command;
import com.rea.toyrobot.input.InputHandler;
import com.rea.toyrobot.robot.ToyRobot;
import com.rea.toyrobot.state.State;
import com.rea.toyrobot.tabletop.TableTop;

import java.util.List;

public class ToyRobotSimulator {

    private final InputHandler inputHandler;
    private final ToyRobot toyRobot;
    private final TableTop tableTop;

    public ToyRobotSimulator(InputHandler inputHandler, ToyRobot toyRobot, TableTop tableTop) {
        this.inputHandler = inputHandler;
        this.toyRobot = toyRobot;
        this.tableTop = tableTop;
    }

    public static void main(String[] args) {

    }

    public void runSimulator(String[] args) {
        List<Command> commandList = inputHandler.getCommands(args);
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

package com.rea.toyrobot.simulator;

import com.rea.toyrobot.command.Command;
import com.rea.toyrobot.input.InputHandler;
import com.rea.toyrobot.placement.Placement;
import com.rea.toyrobot.robot.ToyRobot;

import java.util.Collections;
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

    public ToyRobotSimulator(InputHandler inputHandler, ToyRobot toyRobot) {
        this.inputHandler = inputHandler;
        this.toyRobot = toyRobot;
    }

    public void play(String[] args) {
        //1. Receive commands from player/client
        Optional<List<Command>> commandList = inputHandler.getCommands(args, this.toyRobot);

        //2. Execute commands
        List<Command> commandStream = commandList.orElse(Collections.emptyList());
        commandStream.forEach(command -> command.perform());
    }

    public String getReportString() {
        String ret;
        Placement currentPlacement = this.toyRobot.getPlacement();
        if(currentPlacement != null) {
            ret =  String.format("%s,%s,%s", currentPlacement.getxPosition(), currentPlacement.getyPosition(),
                    currentPlacement.getDirection());
        } else {
            ret = "Toy Robot not in play.";
        }
        return ret;
    }
}

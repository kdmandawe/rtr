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

    /**
     * Instantiates a new Toy robot simulator.
     *
     * @param inputHandler the input handler to receive commands from client
     * @param toyRobot     the toy robot to execute the commands
     */
    ToyRobotSimulator(InputHandler inputHandler, ToyRobot toyRobot) {
        this.inputHandler = inputHandler;
        this.toyRobot = toyRobot;
    }

    /**
     * Simulates the actual recording of commands and translating them to Robot Actions
     *
     * @param args the arguments as input from user/client
     */
    public void play(String[] args) {
        //1. Receive commands from player/client
        Optional<List<Command>> commandList = inputHandler.getCommands(args, this.toyRobot);

        //2. Execute commands
        List<Command> commandStream = commandList.orElse(Collections.emptyList());
        commandStream.forEach(Command::perform);
    }

    /**
     * Publishes the report string indicating current placement of robot.
     *
     * @return the report string
     */
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

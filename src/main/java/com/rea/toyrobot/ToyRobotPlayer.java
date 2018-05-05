package com.rea.toyrobot;

import com.rea.toyrobot.input.InputHandlers;
import com.rea.toyrobot.simulator.SimulatorBuilder;
import com.rea.toyrobot.simulator.ToyRobotSimulator;
import com.rea.toyrobot.tabletop.TableTops;

/**
 * Main entry point for the ToyRobot Application. This also serves as the client which
 * builds and plays the ToyRobot Simulator
 */
public class ToyRobotPlayer {

    public static void main(String[] args) {
        //1. Build the simulator
        // through builder and factories, it's easy for clients to start run the simulator right away!
        ToyRobotSimulator simulator = SimulatorBuilder.newBuilder()
                .inputHandler(InputHandlers.newSmartInputHandler())
                .tableTop(TableTops.newSquareTableTopDontAllowFall(5, 5))
                .basicToyRobot()
                .build();


        //2. start playing
        simulator.play(args);

        ToyRobotSimulator simulator1 = SimulatorBuilder.newBuilder().inputHandler(InputHandlers.newSmartInputHandler
                ()).tableTop(TableTops.newSquareTableTopDontAllowFall(5, 5)).basicToyRobot().build();
    }
}

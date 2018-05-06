package com.rea.toyrobot;

import com.rea.toyrobot.common.util.PropertyProviders;
import com.rea.toyrobot.input.InputHandlers;
import com.rea.toyrobot.simulator.SimulatorBuilder;
import com.rea.toyrobot.simulator.ToyRobotSimulator;
import com.rea.toyrobot.tabletop.TableTops;

/**
 * Main entry point for the ToyRobot Application. This also serves as the client which
 * builds and plays the ToyRobot Simulator
 */
public class ToyRobotPlayer {

    private static final String APPLICATON_PROPERTIES = "application.properties";

    /**
     * The entry point of application. This uses the very convenient SimulatorBuilder which
     * implements the Step Builder pattern and therefore provides an easy-to-follow guide(as you code)
     * on how to create and run the simulator instance.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        //1. Build the simulator
        // through builder and factories, it's easy for clients to start run the simulator right away!
        ToyRobotSimulator simulator = SimulatorBuilder.newBuilder()
                .inputHandler(InputHandlers.newSmartInputHandler())
                .tableTop(TableTops.newSquareTableTopDontAllowFall(PropertyProviders.newFilePropertyProvider
                        (APPLICATON_PROPERTIES)))
                .basicToyRobot()
                .build();


        //2. start playing
        simulator.play(args);
    }
}

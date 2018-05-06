package com.rea.toyrobot.simulator;

import com.rea.toyrobot.input.InputHandlers;
import com.rea.toyrobot.tabletop.TableTops;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SimulatorBuilderTest {

    @Test
    public void testSimulatorBuilderCreateSimulatorInstance() {
        ToyRobotSimulator simulator = SimulatorBuilder.newBuilder()
                .inputHandler(InputHandlers.newSmartInputHandler())
                .tableTop(TableTops.newSquareTableTopDontAllowFall(5, 5))
                .basicToyRobot()
                .build();
        assertNotNull(simulator);
    }

}
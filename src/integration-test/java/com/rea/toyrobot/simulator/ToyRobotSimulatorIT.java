package com.rea.toyrobot.simulator;

import com.rea.toyrobot.IntegrationTest;
import com.rea.toyrobot.input.InputHandlers;
import com.rea.toyrobot.tabletop.TableTops;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertEquals;

@Category(IntegrationTest.class)
public class ToyRobotSimulatorIT {

    ToyRobotSimulator simulator;

    @Before
    public void setUp() {

        simulator = SimulatorBuilder.newBuilder()
                .inputHandler(InputHandlers.newSmartInputHandler())
                .tableTop(TableTops.newSquareTableTopDontAllowFall(5, 5))
                .basicToyRobot()
                .build();
    }

    @Test
    public void testMoveOneUp() {
        String path = getClass().getClassLoader().getResource("input_it_001.txt").getPath();
        String[] args = {path};
        simulator.play(args);
        assertEquals("0,1,NORTH", simulator.getReportString());
    }

    @Test
    public void testFaceLeft() {
        String path = getClass().getClassLoader().getResource("input_it_002.txt").getPath();
        String[] args = {path};
        simulator.play(args);
        assertEquals("0,0,WEST", simulator.getReportString());
    }

    @Test
    public void testSeriesOfValidMoves() {
        String path = getClass().getClassLoader().getResource("input_it_003.txt").getPath();
        String[] args = {path};
        simulator.play(args);
        assertEquals("3,3,NORTH", simulator.getReportString());
    }

}

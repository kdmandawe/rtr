package com.rea.toyrobot.simulator;

import com.rea.toyrobot.IntegrationTest;
import com.rea.toyrobot.common.util.PropertyProviders;
import com.rea.toyrobot.input.InputHandler;
import com.rea.toyrobot.input.InputHandlers;
import com.rea.toyrobot.robot.ToyRobot;
import com.rea.toyrobot.robot.ToyRobots;
import com.rea.toyrobot.tabletop.TableTop;
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
        InputHandler inputHandler = InputHandlers.newSmartInputHandler();
        ToyRobot toyRobot = ToyRobots.newBasicToyRobot();
        TableTop tableTop = TableTops.newSquareTableTopAllowFall(PropertyProviders.newFilePropertyProvider("application-it.properties"));
        simulator = new ToyRobotSimulator(inputHandler, toyRobot, tableTop);
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

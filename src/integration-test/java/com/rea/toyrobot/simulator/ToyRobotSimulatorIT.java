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

    private static final String ROBOT_NOT_IN_PLAY = "Toy Robot not in play.";

    private ToyRobotSimulator simulator;

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

    @Test
    public void testFaceRight() {
        String path = getClass().getClassLoader().getResource("input_it_004.txt").getPath();
        String[] args = {path};
        simulator.play(args);
        assertEquals("1,0,EAST", simulator.getReportString());
    }

    @Test
    public void testMultiplePlace() {
        String path = getClass().getClassLoader().getResource("input_it_005.txt").getPath();
        String[] args = {path};
        simulator.play(args);
        assertEquals("4,4,EAST", simulator.getReportString());
    }

    @Test
    public void testInvalidPlace() {
        String path = getClass().getClassLoader().getResource("input_it_006.txt").getPath();
        String[] args = {path};
        simulator.play(args);
        assertEquals(ROBOT_NOT_IN_PLAY, simulator.getReportString());
    }

    @Test
    public void testRobotShouldNotFallAtX() {
        String path = getClass().getClassLoader().getResource("input_it_007.txt").getPath();
        String[] args = {path};
        simulator.play(args);
        assertEquals("4,0,EAST", simulator.getReportString());
    }

    @Test
    public void testRobotShouldNotFallAtY() {
        String path = getClass().getClassLoader().getResource("input_it_008.txt").getPath();
        String[] args = {path};
        simulator.play(args);
        assertEquals("0,4,NORTH", simulator.getReportString());
    }

    @Test
    public void testPlaceCommandWithoutArgs() {
        String path = getClass().getClassLoader().getResource("input_it_009.txt").getPath();
        String[] args = {path};
        simulator.play(args);
        assertEquals(ROBOT_NOT_IN_PLAY, simulator.getReportString());
    }

    @Test
    public void testPlaceCommandWithInvalidXArg() {
        String path = getClass().getClassLoader().getResource("input_it_010.txt").getPath();
        String[] args = {path};
        simulator.play(args);
        assertEquals(ROBOT_NOT_IN_PLAY, simulator.getReportString());
    }

    @Test
    public void testPlaceCommandWithInvalidYArg() {
        String path = getClass().getClassLoader().getResource("input_it_011.txt").getPath();
        String[] args = {path};
        simulator.play(args);
        assertEquals(ROBOT_NOT_IN_PLAY, simulator.getReportString());
    }

    @Test
    public void testPlaceCommandWithInvalidDirectionArg() {
        String path = getClass().getClassLoader().getResource("input_it_012.txt").getPath();
        String[] args = {path};
        simulator.play(args);
        assertEquals(ROBOT_NOT_IN_PLAY, simulator.getReportString());
    }

    @Test
    public void testEmptyCommandList() {
        String path = getClass().getClassLoader().getResource("input_it_013.txt").getPath();
        String[] args = {path};
        simulator.play(args);
        assertEquals(ROBOT_NOT_IN_PLAY, simulator.getReportString());
    }

}

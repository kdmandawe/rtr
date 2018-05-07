package com.rea.toyrobot.command;

import com.rea.toyrobot.BaseUnitTest;
import com.rea.toyrobot.robot.ToyRobot;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class CommandsTest extends BaseUnitTest {

    private ToyRobot toyRobot;

    @Before
    public void setUp() {
        toyRobot = Mockito.mock(ToyRobot.class);
    }

    @Test
    public void createPlaceCommand() {
        Command command = Commands.newCommand("PLACE 0,0,NORTH", toyRobot);
        assertNotNull(command);
        assertTrue(command instanceof PlaceCommand);
    }

    @Test
    public void createPlaceCommandNoPlacementArgs() {
        Command command = Commands.newCommand("PLACE", toyRobot);
        assertNull(command);
    }

    @Test
    public void createMoveCommand() {
        Command command = Commands.newCommand("MOVE", toyRobot);
        assertNotNull(command);
        assertTrue(command instanceof MoveCommand);
    }

    @Test
    public void createMoveCommandInvalid() {
        Command command = Commands.newCommand("MOVE1", toyRobot);
        assertNull(command);
    }

    @Test
    public void createLeftCommand() {
        Command command = Commands.newCommand("LEFT", toyRobot);
        assertNotNull(command);
        assertTrue(command instanceof LeftCommand);
    }

    @Test
    public void createLeftCommandInvalid() {
        Command command = Commands.newCommand("LEFTRIGHT", toyRobot);
        assertNull(command);
    }

    @Test
    public void createRightCommand() {
        Command command = Commands.newCommand("RIGHT", toyRobot);
        assertNotNull(command);
        assertTrue(command instanceof RightCommand);
    }

    @Test
    public void createRightCommandInvalid() {
        Command command = Commands.newCommand("RIGHTLEFT", toyRobot);
        assertNull(command);
    }

    @Test
    public void createReportCommand() {
        Command command = Commands.newCommand("REPORT", toyRobot);
        assertNotNull(command);
        assertTrue(command instanceof ReportCommand);
    }

    @Test
    public void createReportCommandInvalid() {
        Command command = Commands.newCommand("REPORT123", toyRobot);
        assertNull(command);
    }

    @Test
    public void testFactoryWellDefined() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        testUtilityClassWellDefined(Commands.class);
    }
}
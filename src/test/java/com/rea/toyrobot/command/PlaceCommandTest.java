package com.rea.toyrobot.command;

import com.rea.toyrobot.placement.Direction;
import com.rea.toyrobot.placement.Placement;
import com.rea.toyrobot.robot.ToyRobot;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PlaceCommandTest {

    private ToyRobot toyRobot;

    @Before
    public void setUp() {
        toyRobot = Mockito.mock(ToyRobot.class);
    }

    @Test
    public void testPlacePerformCommand() {
        Placement placement = new Placement(0, 0, Direction.NORTH);
        Command placeCommand = new PlaceCommand(placement, toyRobot);
        placeCommand.perform();
        verify(toyRobot, times(1)).doPlace(placement);
    }

    @Test
    public void testCreateInstanceWithoutPlacementObject() {
        Command command = new PlaceCommand(0, 0, Direction.NORTH, toyRobot);
        assertNotNull(command);
    }

    @Test
    public void testPlaceCommandToString() {
        Command placeCommand = new PlaceCommand(0, 0, Direction.NORTH, toyRobot);
        assertTrue(placeCommand.toString() != null && placeCommand.toString().startsWith
                ("PlaceCommand{placement="));
    }

}
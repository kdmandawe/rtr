package com.rea.toyrobot.command;

import com.rea.toyrobot.robot.ToyRobot;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MoveCommandTest {

    private ToyRobot toyRobot;

    @Before
    public void setUp() {
        toyRobot = Mockito.mock(ToyRobot.class);
    }

    @Test
    public void testMovePerformCommand() {
        Command moveCommand = new MoveCommand(toyRobot);
        moveCommand.perform();
        verify(toyRobot, times(1)).doMove();
    }

    @Test
    public void testMoveCommandToString() {
        Command moveCommand = new MoveCommand(toyRobot);
        assertTrue(moveCommand.toString() != null && moveCommand.toString().startsWith("MoveCommand{toyRobot=Mock " +
                "for ToyRobot, hashCode:"));
    }

}
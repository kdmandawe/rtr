package com.rea.toyrobot.command;

import com.rea.toyrobot.robot.ToyRobot;
import com.rea.toyrobot.robot.TurnDirection;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LeftCommandTest {

    private ToyRobot toyRobot;

    @Before
    public void setUp() {
        toyRobot = Mockito.mock(ToyRobot.class);
    }

    @Test
    public void testLeftPerformCommand() {
        Command leftCommand = new LeftCommand(toyRobot);
        leftCommand.perform();
        verify(toyRobot, times(1)).doTurn(TurnDirection.LEFT);
    }

    @Test
    public void testLeftCommandToString() {
        Command leftCommand = new LeftCommand(toyRobot);
        assertTrue(leftCommand.toString() != null && leftCommand.toString().startsWith("LeftCommand{toyRobot=Mock for ToyRobot, hashCode:"));
    }

}
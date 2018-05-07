package com.rea.toyrobot.command;

import com.rea.toyrobot.robot.ToyRobot;
import com.rea.toyrobot.robot.TurnDirection;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RightCommandTest {

    private ToyRobot toyRobot;

    @Before
    public void setUp() {
        toyRobot = Mockito.mock(ToyRobot.class);
    }

    @Test
    public void testRightPerformCommand() {
        Command rightCommand = new RightCommand(toyRobot);
        rightCommand.perform();
        verify(toyRobot, times(1)).doTurn(TurnDirection.RIGHT);
    }

    @Test
    public void testReportCommandToString() {
        Command rightCommand = new RightCommand(toyRobot);
        assertTrue(rightCommand.toString() != null && rightCommand.toString().startsWith
                ("RightCommand{toyRobot=Mock for ToyRobot, hashCode:"));
    }

}
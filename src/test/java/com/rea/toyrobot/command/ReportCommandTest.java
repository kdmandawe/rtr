package com.rea.toyrobot.command;

import com.rea.toyrobot.robot.ToyRobot;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ReportCommandTest {

    private ToyRobot toyRobot;

    @Before
    public void setUp() {
        toyRobot = Mockito.mock(ToyRobot.class);
    }

    @Test
    public void testPlacePerformCommand() {
        Command reportCommand = new ReportCommand(toyRobot);
        reportCommand.perform();
        verify(toyRobot, times(1)).doReport();
    }

}
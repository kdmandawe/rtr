package com.rea.toyrobot.input;

import com.rea.toyrobot.command.Command;
import com.rea.toyrobot.robot.ToyRobot;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class InputHandlersTest {

    private ToyRobot toyRobot;

    @Before
    public void setUp() {
        toyRobot = Mockito.mock(ToyRobot.class);
    }

    @Test
    public void inputHandlersShouldCreateInputHandlerInstance() {
        InputHandler handler = InputHandlers.newSmartInputHandler();
        assertNotNull(handler);
    }

    @Test
    public void givenFileInputShouldReturnListOfCommands() {
        InputHandler handler = InputHandlers.newSmartInputHandler();
        Optional<List<Command>> commands = handler.getCommands(new String[]{"input_ut_001.txt"}, toyRobot);
        assertTrue(commands.isPresent());
        assertEquals(3, commands.get().size());
    }

}
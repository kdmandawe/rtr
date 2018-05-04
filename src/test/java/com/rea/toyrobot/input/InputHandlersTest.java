package com.rea.toyrobot.input;

import com.rea.toyrobot.command.Command;
import com.rea.toyrobot.robot.ToyRobot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class InputHandlersTest {

    private ToyRobot toyRobot;
    private InputStream stdin = System.in;

    @Before
    public void setUp() {
        toyRobot = Mockito.mock(ToyRobot.class);
    }

    @Test
    public void testInputHandlersCreateInputHandlerInstance() {
        InputHandler handler = InputHandlers.newSmartInputHandler();
        assertNotNull(handler);
    }

    @Test
    public void testFileInputShouldReturnListOfCommands() {
        InputHandler handler = InputHandlers.newSmartInputHandler();
        Optional<List<Command>> commands = handler.getCommands(new String[]{"input_ut_001.txt"}, toyRobot);
        assertTrue(commands.isPresent());
        assertEquals(3, commands.get().size());
    }

    @Test
    public void testNonFileInputShouldReturnListOfCommands() {
        String data = "MOVE\n" +
                "LEFT\n" +
                "RIGHT\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        InputHandler handler = InputHandlers.newSmartInputHandler();
        Optional<List<Command>> commands = handler.getCommands(new String[]{}, toyRobot);
        assertTrue(commands.isPresent());
        assertEquals(3, commands.get().size());
    }

    @After
    public void tearDown() {
        System.setIn(stdin);
    }

}
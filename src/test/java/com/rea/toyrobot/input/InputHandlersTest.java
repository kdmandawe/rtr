package com.rea.toyrobot.input;

import com.rea.toyrobot.BaseUnitTest;
import com.rea.toyrobot.command.Command;
import com.rea.toyrobot.robot.ToyRobot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class InputHandlersTest extends BaseUnitTest {

    private ToyRobot toyRobot;
    private final InputStream stdin = System.in;

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
        String path = getClass().getClassLoader().getResource("input_ut_001.txt").getPath();
        Optional<List<Command>> commands = handler.getCommands(new String[]{path}, toyRobot);
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

    @Test
    public void testInputHandlersClassWellDefined()
            throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        testUtilityClassWellDefined(InputHandlers.class);
    }

    @After
    public void tearDown() {
        System.setIn(stdin);
    }

}
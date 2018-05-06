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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StdInInputHandlerTest {

    private ToyRobot toyRobot;
    private final InputStream stdin = System.in;

    @Before
    public void setup() {
        toyRobot = Mockito.mock(ToyRobot.class);
    }

    @Test
    public void testGetCommandsFromStdInWithContent() {
        //given
        String data = "MOVE\n" +
                "LEFT\n" +
                "RIGHT\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        //when
        StdInInputHandler inputHandler = new StdInInputHandler();
        Optional<List<Command>> commands = inputHandler.getCommands(new String[]{}, toyRobot);
        //then
        assertTrue(commands.isPresent());
        assertEquals(3, commands.get().size());


    }

    @Test
    public void testGetCommandsFromStdWithOutContent() {
        //given
        String data = "\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        //when
        StdInInputHandler inputHandler = new StdInInputHandler();
        Optional<List<Command>> commands = inputHandler.getCommands(new String[]{}, toyRobot);
        //then
        assertTrue(commands.get().isEmpty());
    }

    @Test
    public void testGetCommandsFromStdWithSomeInvalidContent() {
        //given
        String data = "PLACE 0,0,NORTH\n" +
                "HELLO\n" +
                "\n" +
                "REPORT\n" +
                "WHY\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        //when
        StdInInputHandler inputHandler = new StdInInputHandler();
        Optional<List<Command>> commands = inputHandler.getCommands(new String[]{}, toyRobot);
        //then
        assertFalse(commands.get().isEmpty());
        assertTrue(commands.get().size() == 2);
    }

    @After
    public void tearDown() {
        System.setIn(stdin);
    }
}
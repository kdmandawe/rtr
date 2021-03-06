package com.rea.toyrobot.input;

import com.rea.toyrobot.command.Command;
import com.rea.toyrobot.common.exception.SimulatorException;
import com.rea.toyrobot.robot.ToyRobot;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileInputHandlerTest {

    private ToyRobot toyRobot;

    @Before
    public void setup() {
        toyRobot = Mockito.mock(ToyRobot.class);
    }

    @Test
    public void testGetCommandsFromFileWithContent() {
        FileInputHandler inputHandler = new FileInputHandler();
        String path = getClass().getClassLoader().getResource("input_ut_002.txt").getPath();
        Optional<List<Command>> commands = inputHandler.getCommands(new String[]{path}, toyRobot);
        assertTrue(commands.isPresent());
        assertEquals(3, commands.get().size());
    }

    @Test
    public void testGetCommandsFromFileWithOutContent() {
        FileInputHandler inputHandler = new FileInputHandler();
        String path = getClass().getClassLoader().getResource("input_ut_003.txt").getPath();
        Optional<List<Command>> commands = inputHandler.getCommands(new String[]{path}, toyRobot);
        assertTrue(commands.get().isEmpty());
    }

    @Test
    public void testGetCommandsFromFileWithSomeInvalidContent() {
        FileInputHandler inputHandler = new FileInputHandler();
        String path = getClass().getClassLoader().getResource("input_ut_004.txt").getPath();
        Optional<List<Command>> commands = inputHandler.getCommands(new String[]{path}, toyRobot);
        assertFalse(commands.get().isEmpty());
        assertTrue(commands.get().size() == 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCommandsNoArgsPassed() {
        FileInputHandler inputHandler = new FileInputHandler();
        Optional<List<Command>> commands = inputHandler.getCommands(new String[]{}, toyRobot);
        assertFalse(commands.isPresent());
    }

    @Test(expected = SimulatorException.class)
    public void testGetCommandsFromInvalidFileName() {
        FileInputHandler inputHandler = new FileInputHandler();
        Optional<List<Command>> commands = inputHandler.getCommands(new String[]{"nonexisting.txt"}, toyRobot);
        assertTrue(commands.get().isEmpty());
    }

}
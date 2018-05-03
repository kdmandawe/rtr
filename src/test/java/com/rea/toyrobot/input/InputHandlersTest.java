package com.rea.toyrobot.input;

import com.rea.toyrobot.command.Command;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class InputHandlersTest {

    @Test
    public void inputHandlersShouldCreateInputHandlerInstance() {
        InputHandler handler = InputHandlers.newSmartInputHandler();
        assertNotNull(handler);
    }

    @Test
    public void givenFileInputShouldReturnListOfCommands() {
        InputHandler handler = InputHandlers.newSmartInputHandler();
        List<Command> commands = handler.getCommands(new String[]{"input_ut_001.txt"});
        assertNotNull(commands);
        assertEquals(3, commands.size());
    }

}
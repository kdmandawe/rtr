package com.rea.toyrobot.command;

import org.junit.Test;

import static com.rea.toyrobot.command.KnownCommands.*;
import static org.junit.Assert.assertEquals;

public class KnownCommandsTest {

    @Test
    public void testCreatePlaceEnumFromString() {
        KnownCommands result = KnownCommands.fromString("PLACE");
        assertEquals(PLACE, result);
    }

    @Test
    public void testCreateMoveEnumFromString() {
        KnownCommands result = KnownCommands.fromString("MOVE");
        assertEquals(MOVE, result);
    }

    @Test
    public void testCreateLeftEnumFromString() {
        KnownCommands result = KnownCommands.fromString("LEFT");
        assertEquals(LEFT, result);
    }

    @Test
    public void testCreateRightEnumFromString() {
        KnownCommands result = KnownCommands.fromString("RIGHT");
        assertEquals(RIGHT, result);
    }

    @Test
    public void testCreateReportEnumFromString() {
        KnownCommands result = KnownCommands.fromString("REPORT");
        assertEquals(REPORT, result);
    }

}
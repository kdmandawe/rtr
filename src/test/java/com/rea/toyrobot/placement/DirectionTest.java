package com.rea.toyrobot.placement;

import org.junit.Test;

import static com.rea.toyrobot.placement.Direction.*;
import static org.junit.Assert.assertEquals;

public class DirectionTest {

    @Test
    public void testCreateNorthDirectionFromString() {
        Direction result = Direction.fromString("NORTH");
        assertEquals(NORTH, result);
    }

    @Test
    public void testCreateSouthDirectionFromString() {
        Direction result = Direction.fromString("SOUTH");
        assertEquals(SOUTH, result);
    }

    @Test
    public void testCreateEastDirectionFromString() {
        Direction result = Direction.fromString("EAST");
        assertEquals(EAST, result);
    }

    @Test
    public void testCreateWestDirectionFromString() {
        Direction result = Direction.fromString("WEST");
        assertEquals(WEST, result);
    }
}
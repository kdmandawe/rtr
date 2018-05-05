package com.rea.toyrobot.placement;

import org.junit.Test;

import static com.rea.toyrobot.placement.Direction.NORTH;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlacementTest {

    @Test
    public void testCreatePlacmentInstance() {
        Placement placement = new Placement(0, 0, NORTH);
        assertNotNull(placement);
    }

    @Test
    public void testGetX() {
        Placement placement = new Placement(0, 0, NORTH);
        assertEquals(0, placement.getxPosition());
    }

    @Test
    public void testGetY() {
        Placement placement = new Placement(0, 0, NORTH);
        assertEquals(0, placement.getyPosition());
    }

    @Test
    public void testGetDirection() {
        Placement placement = new Placement(0, 0, NORTH);
        assertEquals(NORTH, placement.getDirection());
    }

    @Test
    public void testEqualityOfPlacments() {
        Placement placement1 = new Placement(0, 0, NORTH);
        Placement placement2 = new Placement(0, 0, NORTH);
        assertEquals(placement1, placement2);
    }

}
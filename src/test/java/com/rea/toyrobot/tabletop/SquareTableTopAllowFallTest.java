package com.rea.toyrobot.tabletop;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SquareTableTopAllowFallTest {

    @Test
    public void testCreateSquareTableTopAllowFall() {
        TableTop tableTop = new SquareTableTopAllowFall(5, 5);
        assertNotNull(tableTop);
        assertTrue(tableTop.allowFall());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSquareTableTopAllowFallUnequalWidthHeight() {
        TableTop tableTop = new SquareTableTopAllowFall(6, 5);
    }

}
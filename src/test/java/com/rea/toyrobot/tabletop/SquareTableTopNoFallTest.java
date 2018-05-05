package com.rea.toyrobot.tabletop;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class SquareTableTopNoFallTest {

    @Test
    public void testCreateSquareTableTopNoFall() {
        TableTop tableTop = new SquareTableTopNoFall(5, 5);
        assertNotNull(tableTop);
        assertFalse(tableTop.allowFall());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSquareTableTopNoFallUnequalWidthHeight() {
        TableTop tableTop = new SquareTableTopNoFall(6, 5);
    }

}
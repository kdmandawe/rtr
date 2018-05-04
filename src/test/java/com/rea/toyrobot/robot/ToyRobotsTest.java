package com.rea.toyrobot.robot;

import com.rea.toyrobot.tabletop.TableTops;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ToyRobotsTest {

    @Test
    public void testCreateToyRobot() {
        ToyRobot toyRobot = ToyRobots.newBasicToyRobot(TableTops.newSquareTableTopDontAllowFall(5, 5));
        assertNotNull(toyRobot);
    }

}
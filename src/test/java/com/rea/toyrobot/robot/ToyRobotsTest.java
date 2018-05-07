package com.rea.toyrobot.robot;

import com.rea.toyrobot.BaseUnitTest;
import com.rea.toyrobot.tabletop.TableTops;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertNotNull;

public class ToyRobotsTest extends BaseUnitTest {

    @Test
    public void testCreateToyRobot() {
        ToyRobot toyRobot = ToyRobots.newBasicToyRobot(TableTops.newSquareTableTopDontAllowFall(5, 5));
        assertNotNull(toyRobot);
    }

    @Test
    public void testToyRobotsClassWellDefined()
            throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        testUtilityClassWellDefined(ToyRobots.class);
    }

}
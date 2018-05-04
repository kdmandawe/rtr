package com.rea.toyrobot.robot;

import com.rea.toyrobot.tabletop.TableTop;

/**
 * Factory class for creating ToyRobot instances
 */
public class ToyRobots {
    public static ToyRobot newBasicToyRobot(TableTop tableTop){
        return new BasicToyRobot(tableTop);
    }
}

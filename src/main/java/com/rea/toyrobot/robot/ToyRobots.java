package com.rea.toyrobot.robot;

import com.rea.toyrobot.tabletop.TableTop;

/**
 * Factory class for creating ToyRobot instances
 */
public class ToyRobots {

    private ToyRobots() {
        //should not be instantiated
    }

    /**
     * Creates an instance of {@link BasicToyRobot}.
     *
     * @param tableTop the table top where the toy robot will play.
     * @return the toy robot
     */
    public static ToyRobot newBasicToyRobot(TableTop tableTop){
        return new BasicToyRobot(tableTop);
    }
}

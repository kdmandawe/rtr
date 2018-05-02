package com.rea.toyrobot.robot;

/**
 * Factory class for creating ToyRobot instances
 */
public class ToyRobots {
    public static ToyRobot newBasicToyRobot(){
        return new BasicToyRobot();
    }
}

package com.rea.toyrobot.robot;

import com.rea.toyrobot.placement.Placement;

/**
 * Class that defines the behavior of concrete ToyRobots
 */
public interface ToyRobot {
    Placement getPlacement();
    boolean inPlay();
    void doPlace(Placement placement);
    void doMove();
    void doTurn(TurnDirection direction);
    void doReport();
}

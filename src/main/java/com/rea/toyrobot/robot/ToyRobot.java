package com.rea.toyrobot.robot;

import com.rea.toyrobot.placement.Placement;

/**
 * Class that defines the behavior of concrete ToyRobots
 */
public interface ToyRobot {
    /**
     * Gets the current placement of robot.
     *
     * @return the placement
     */
    Placement getPlacement();

    /**
     * Determines if the toy robot is already placed in the table top performing actions.
     *
     * @return the boolean
     */
    boolean inPlay();

    /**
     * Executes placement of the toy robot into one of the table cells with direction where
     * robot is facing.
     *
     * @param placement the placement
     */
    void doPlace(Placement placement);

    /**
     * Moves 1 step  forward.
     */
    void doMove();

    /**
     * Turn either left or right.
     *
     * @param direction the direction
     */
    void doTurn(TurnDirection direction);

    /**
     * Publishes the report stating current placement.
     */
    void doReport();
}

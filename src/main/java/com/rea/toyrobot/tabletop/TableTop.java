package com.rea.toyrobot.tabletop;

/**
 * Interface for the table top where a toy-robot can move around
 */
public interface TableTop {
    /**
     * Gets max x position.
     *
     * @return the max x position
     */
    int getMaxXPosition();

    /**
     * Gets max y position.
     *
     * @return the max y position
     */
    int getMaxYPosition();

    /**
     * Determines if the table does allow the robot to fall in case that a 'MOVE' or 'PLACE'
     * command will exceed maximun x or maximum y
     *
     * @return the boolean
     */
    boolean allowFall();
}

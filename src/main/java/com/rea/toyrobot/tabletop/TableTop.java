package com.rea.toyrobot.tabletop;

/**
 * Interface for the table top where a toy-robot can move around
 */
public interface TableTop {
    int getMaxXPosition();
    int getMaxYPosition();
    boolean allowFall();
}

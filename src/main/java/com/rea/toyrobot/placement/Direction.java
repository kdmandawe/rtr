package com.rea.toyrobot.placement;

import com.rea.toyrobot.common.util.EnumUtils;

/**
 * The enum Direction represents where a {@link com.rea.toyrobot.robot.ToyRobot} is facing.
 */
public enum Direction {

    /**
     * North direction.
     */
    NORTH,
    /**
     * South direction.
     */
    SOUTH,
    /**
     * East direction.
     */
    EAST,
    /**
     * West direction.
     */
    WEST;

    /**
     * Convert a given string to {@link Direction} instance.
     *
     * @param direction the direction String to convert to {@link Direction}
     * @return the {@link Direction} instance
     */
    public static Direction fromString(String direction) {
        return EnumUtils.fromString(Direction.class, direction).orElse(null);
    }
}

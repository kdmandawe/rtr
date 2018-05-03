package com.rea.toyrobot.placement;

import com.rea.toyrobot.common.util.EnumUtils;

public enum Direction {

    NORTH, SOUTH, EAST, WEST;

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

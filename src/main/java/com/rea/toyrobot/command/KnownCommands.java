package com.rea.toyrobot.command;

import com.rea.toyrobot.common.util.EnumUtils;

/**
 * The enum of Known commands. This will enforce that no other arbitrary command will be accepted.
 */
public enum KnownCommands {

    /**
     * Corresponds to PlaceCommand
     */
    PLACE,
    /**
     * Corresponds to MoveCommand
     */
    MOVE,
    /**
     * Corresponds to LeftCommand
     */
    LEFT,
    /**
     * Corresponds to RightCommand
     */
    RIGHT,
    /**
     * Corresponds to ReportCommand
     */
    REPORT;

    /**
     * Convert a given string to Command instance.
     *
     * @param command the command String to conver to {@link KnownCommands}
     * @return the           Command instance
     */
    public static KnownCommands fromString(String command) {
        return EnumUtils.fromString(KnownCommands.class, command).orElse(null);
    }
}

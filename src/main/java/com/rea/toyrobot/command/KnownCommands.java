package com.rea.toyrobot.command;

import com.rea.toyrobot.common.util.EnumUtils;

public enum KnownCommands {

    PLACE, MOVE, LEFT, RIGHT, REPORT;

    /**
     * Convert a given string to Command instance.
     *
     * @param command
     *          the command String to conver to {@link KnownCommands}
     * @return
     *          the Command instance
     */
    public static KnownCommands fromString(String command) {
        return EnumUtils.fromString(KnownCommands.class, command).orElse(null);
    }
}

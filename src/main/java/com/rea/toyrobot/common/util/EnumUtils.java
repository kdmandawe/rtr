package com.rea.toyrobot.common.util;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Utility class for enums
 */
public final class EnumUtils {

    private EnumUtils(){}

    /**
     * Checks if the specified name is a valid enum for the class and then converts it to
     * the expected enum.
     *
     * @param <T>       the type of the enumeration
     * @param enumClass the class of the enum to query, not null
     * @param name      the enum name, null returns false
     * @return the           Optional containing the enum
     */
    public static <T extends Enum<?>> Optional<T> fromString(Class<T> enumClass,
                                                             String name) {

        if(enumClass == null || name == null || name.isEmpty()) {
            return Optional.empty();
        }

        return Stream.of(enumClass.getEnumConstants())
                .filter(enumInstance -> enumInstance.name().compareToIgnoreCase(name) == 0)
                .findFirst();
    }

}

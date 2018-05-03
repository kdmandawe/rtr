package com.rea.toyrobot.common.util;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Utility class for enums
 */
public class EnumUtils {

    private EnumUtils(){}

    /**
     * Checks if the specified name is a valid enum for the class.
     *
     * @param <T>
     *          the type of the enumeration
     * @param enumClass
     *          the class of the enum to query, not null
     * @param name
     *          the enum name, null returns false
     * @return
     *          the Optional containing the enum
     */
    public static <T extends Enum<?>> Optional<T> fromString(Class<T> enumClass,
                                                             String name) {

        if(enumClass == null || name == null || name.isEmpty()) {
            return Optional.empty();
        }

        final Optional<T> first = Stream.of(enumClass.getEnumConstants())
                .filter(enumInstance -> enumInstance.name().compareToIgnoreCase(name) == 0)
                .findFirst();

        return first;
    }

}

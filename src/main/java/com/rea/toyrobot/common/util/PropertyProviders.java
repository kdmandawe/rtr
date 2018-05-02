package com.rea.toyrobot.common.util;

/**
 * Factory class for creating {@link PropertyProvider} instances
 */
public class PropertyProviders {

    public static PropertyProvider newFilePropertyProvider(String fileName) {
        return new FilePropertyProvider(fileName);
    }
}

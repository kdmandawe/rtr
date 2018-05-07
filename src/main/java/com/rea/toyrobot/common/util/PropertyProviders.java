package com.rea.toyrobot.common.util;

/**
 * Factory class for creating {@link PropertyProvider} instances
 */
public final class PropertyProviders {

    private PropertyProviders() {
        //should not be instantiated
    }

    /**
     * Creates an instance of {@link FilePropertyProvider} given the file name.
     *
     * @param fileName the file name of the property source
     * @return the created instance property provider
     */
    public static PropertyProvider newFilePropertyProvider(String fileName) {
        return new FilePropertyProvider(fileName);
    }
}

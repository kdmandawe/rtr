package com.rea.toyrobot.common.util;

/**
 * The interface for Property providers to implement. Properties generated will be used
 * by the application. Example could be configurations or other setting that may be dynamic.
 */
public interface PropertyProvider {
    /**
     * Gets property value by passing in the key.
     *
     * @param key the key of the property
     * @return the property value as {@link String}
     */
    String getProperty(String key);
}

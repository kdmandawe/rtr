package com.rea.toyrobot.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This will read application properties from an external file
 */
public class FilePropertyProvider implements PropertyProvider{

    private static final Logger LOG = LoggerFactory.getLogger(FilePropertyProvider.class);

    private final Properties props;

    /**
     * Instantiates a new File property provider.
     *
     * @param fileName the file name which is expected to be present in the classpath
     */
    FilePropertyProvider(String fileName) {
        props = new Properties();
        try(InputStream input = getClass().getClassLoader().getResourceAsStream(fileName)) {
            props.load(input);
        } catch (IOException e) {
            LOG.warn("Error loading properties from file name: {}", fileName);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getProperty(String key) {
        return props.getProperty(key);
    }
}

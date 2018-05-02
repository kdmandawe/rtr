package com.rea.toyrobot.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FilePropertyProvider implements PropertyProvider{

    private static final Logger LOG = LoggerFactory.getLogger(FilePropertyProvider.class);

    private Properties props;
    private InputStream input;

    public FilePropertyProvider(String fileName) {
        props = new Properties();
        try(InputStream input = getClass().getClassLoader().getResourceAsStream(fileName)) {
            props.load(input);
        } catch (IOException e) {
            LOG.warn("Error loading properties from file name: {}", fileName);
        }
    }

    @Override
    public String getProperty(String key) {
        return props.getProperty(key);
    }
}

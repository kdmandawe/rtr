package com.rea.toyrobot.common.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FilePropertyProviderTest {

    @Test
    public void testFilePropertyProviderGetProperty() {
        FilePropertyProvider propertyProvider = new FilePropertyProvider("application-test.properties");
        String  val = propertyProvider.getProperty("test.key1");
        assertEquals("Value1", val);
    }

}
package com.rea.toyrobot.common.util;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PropertyProvidersTest {

    @Test
    public void testCreatePropertyProviderInstance() {
        PropertyProvider propertyProvider = PropertyProviders.newFilePropertyProvider("application-test.properties");
        assertNotNull(propertyProvider);

    }

}
package com.rea.toyrobot.common.util;

import com.rea.toyrobot.BaseUnitTest;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertNotNull;

public class PropertyProvidersTest extends BaseUnitTest {

    @Test
    public void testCreatePropertyProviderInstance() {
        PropertyProvider propertyProvider = PropertyProviders.newFilePropertyProvider("application-test.properties");
        assertNotNull(propertyProvider);

    }

    @Test
    public void testPropertyProvidersClassWellDefined()
            throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        testUtilityClassWellDefined(PropertyProviders.class);
    }

}
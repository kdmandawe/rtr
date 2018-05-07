package com.rea.toyrobot.common.util;

import com.rea.toyrobot.BaseUnitTest;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class EnumUtilsTest extends BaseUnitTest {

    @Test
    public void testEnumUtilsClassWellDefined()
            throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        testUtilityClassWellDefined(EnumUtils.class);
    }

}
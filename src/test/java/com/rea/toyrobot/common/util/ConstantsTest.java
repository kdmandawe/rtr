package com.rea.toyrobot.common.util;

import com.rea.toyrobot.BaseUnitTest;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class ConstantsTest extends BaseUnitTest {

    @Test
    public void testConstantsClassWellDefined()
            throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        testUtilityClassWellDefined(Constants.class);
    }

}
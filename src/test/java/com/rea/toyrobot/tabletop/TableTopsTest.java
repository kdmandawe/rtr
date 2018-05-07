package com.rea.toyrobot.tabletop;

import com.rea.toyrobot.BaseUnitTest;
import com.rea.toyrobot.common.util.PropertyProvider;
import com.rea.toyrobot.common.util.PropertyProviders;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class TableTopsTest extends BaseUnitTest {

    @Test
    public void testCreateSquareTableTopNoFall() {
        TableTop tableTop = TableTops.newSquareTableTopDontAllowFall(5, 5);
        assertNotNull(tableTop);
        assertFalse(tableTop.allowFall());
    }

    @Test
    public void testCreateSquareTableTopAllowFall() {
        TableTop tableTop = TableTops.newSquareTableTopAllowFall(5, 5);
        assertNotNull(tableTop);
        assertTrue(tableTop.allowFall());
    }

    @Test
    public void testCreateSquareTableTopAllowFallFromProperties() {
        PropertyProvider propertyProvider = PropertyProviders.newFilePropertyProvider("application-test.properties");
        TableTop tableTop = TableTops.newSquareTableTopAllowFall(propertyProvider);
        assertNotNull(tableTop);
        assertTrue(tableTop.allowFall());
        assertEquals(4, tableTop.getMaxXPosition());
        assertEquals(4, tableTop.getMaxYPosition());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSquareTableTopAllowFallFromPropertiesBlankEntries() {
        PropertyProvider propertyProvider = PropertyProviders.newFilePropertyProvider("application-blank.properties");
        TableTop tableTop = TableTops.newSquareTableTopAllowFall(propertyProvider);
        assertNull(tableTop);
    }

    @Test
    public void testCreateSquareTableTopNoFallFromProperties() {
        PropertyProvider propertyProvider = PropertyProviders.newFilePropertyProvider("application-test.properties");
        TableTop tableTop = TableTops.newSquareTableTopDontAllowFall(propertyProvider);
        assertNotNull(tableTop);
        assertFalse(tableTop.allowFall());
        assertEquals(4, tableTop.getMaxXPosition());
        assertEquals(4, tableTop.getMaxYPosition());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSquareTableTopNoFallFromPropertiesBlankEntries() {
        PropertyProvider propertyProvider = PropertyProviders.newFilePropertyProvider("application-blank.properties");
        TableTop tableTop = TableTops.newSquareTableTopDontAllowFall(propertyProvider);
        assertNull(tableTop);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSquareTableTopAllowFallUnequalWidthHeight() {
        TableTop tableTop = TableTops.newSquareTableTopAllowFall(6, 5);
        assertNotNull(tableTop);
        assertTrue(tableTop.allowFall());
    }

    @Test
    public void testTableTopsClassWellDefined()
            throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        testUtilityClassWellDefined(TableTops.class);
    }
}
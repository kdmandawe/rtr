package com.rea.toyrobot.common.exception;

import org.junit.Test;

public class SimulatorExceptionTest {

    @Test(expected = SimulatorException.class)
    public void testCreateCustomUncheckedExceptionForCheckedException() {
        throw new SimulatorException("Application error", new Exception());
    }

}
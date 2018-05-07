package com.rea.toyrobot.input;

/**
 * Factory class for creating InputHandlers
 */
public final class InputHandlers {

    private InputHandlers() {
        //should not be instantiated
    }

    /**
     * Creates an instance of {@link SmartInputHandler}.
     *
     * @return the instance input handler
     */
    public static InputHandler newSmartInputHandler() {
        return new SmartInputHandler();
    }
}

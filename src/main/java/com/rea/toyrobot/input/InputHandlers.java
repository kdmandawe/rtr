package com.rea.toyrobot.input;

/**
 * Factory class for creating InputHandlers
 */
public class InputHandlers {

    private InputHandlers() {
        //should not be instantiated
    }

    public static InputHandler newSmartInputHandler() {
        return new SmartInputHandler();
    }
}

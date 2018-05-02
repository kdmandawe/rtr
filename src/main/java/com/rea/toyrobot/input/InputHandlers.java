package com.rea.toyrobot.input;

/**
 * Factory class for creating InputHandlers
 */
public class InputHandlers {

    public static InputHandler newSmartInputHandler() {
        return new SmartInputHandler();
    }
}

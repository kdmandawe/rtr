package com.rea.toyrobot.tabletop;

public class SquareTableTopAllowFall extends SquareTableTop {

    public SquareTableTopAllowFall(int width, int height) {
        super(width, height);
    }
    @Override
    public boolean allowFall() {
        return true;
    }
}

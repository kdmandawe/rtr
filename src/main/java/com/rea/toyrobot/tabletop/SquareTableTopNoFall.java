package com.rea.toyrobot.tabletop;

public class SquareTableTopNoFall extends SquareTableTop {

    SquareTableTopNoFall(int width, int height) {
        super(width, height);
    }
    @Override
    public boolean allowFall() {
        return false;
    }
}

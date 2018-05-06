package com.rea.toyrobot.tabletop;

public abstract class SquareTableTop implements TableTop {

    private int width;
    private int height;

    SquareTableTop(int width, int height) {
        if(width < 0 || height < 0 || width != height) {
            throw new IllegalArgumentException("Impossible to create Square TableTop with passed values!");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public int getMaxXPosition() {
        return this.width - 1;
    }

    @Override
    public int getMaxYPosition() {
        return this.height - 1;
    }
}

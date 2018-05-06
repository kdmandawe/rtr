package com.rea.toyrobot.tabletop;

/**
 * Represents a square table top.
 */
public abstract class SquareTableTop implements TableTop {

    private int width;
    private int height;

    /**
     * Instantiates a new Square table top.
     *
     * @param width  the width
     * @param height the height
     */
    SquareTableTop(int width, int height) {
        if(width < 0 || height < 0 || width != height) {
            throw new IllegalArgumentException("Impossible to create Square TableTop with passed values!");
        }
        this.width = width;
        this.height = height;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMaxXPosition() {
        return this.width - 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMaxYPosition() {
        return this.height - 1;
    }
}

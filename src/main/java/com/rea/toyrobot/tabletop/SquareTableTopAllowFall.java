package com.rea.toyrobot.tabletop;

/**
 * Represent a square {@link TableTop} which allows toy robots to fall
 * in case that a 'MOVE' or 'PLACE' command will exceed maximun x or maximum y.
 */
public class SquareTableTopAllowFall extends SquareTableTop {

    /**
     * Instantiates a new Square table top
     *
     * @param width  the width
     * @param height the height
     */
    public SquareTableTopAllowFall(int width, int height) {
        super(width, height);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean allowFall() {
        return true;
    }
}

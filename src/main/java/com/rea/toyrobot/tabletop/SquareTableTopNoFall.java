package com.rea.toyrobot.tabletop;

/**
 * Represent a square {@link TableTop} which does not allow toy robots to fall
 * in case that a 'MOVE' or 'PLACE' command will exceed maximun x or maximum y.
 */
public class SquareTableTopNoFall extends SquareTableTop {

    /**
     * Instantiates a new Square table.
     *
     * @param width  the width
     * @param height the height
     */
    SquareTableTopNoFall(int width, int height) {
        super(width, height);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean allowFall() {
        return false;
    }
}

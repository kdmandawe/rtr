package com.rea.toyrobot.command;

import com.rea.toyrobot.placement.Direction;
import com.rea.toyrobot.placement.Placement;
import com.rea.toyrobot.robot.ToyRobot;

/**
 * This class represents a Place Command which will be a result of parsing the 'PLACE X,Y,F'
 * raw command input
 */
public final class PlaceCommand implements Command {

    private final Placement placement;
    private final ToyRobot toyRobot;

    /**
     * Instantiates a new Place command.
     *
     * @param placement the {@link Placement} where the toy robot will be placed
     * @param toyRobot  the toy robot which will perform the actual action
     */
    PlaceCommand(Placement placement, ToyRobot toyRobot) {
        this.placement = placement;
        this.toyRobot = toyRobot;
    }

    /**
     * Instantiates a new Place command.
     *
     * @param x         the xPosition where the toy robot will be placed
     * @param y         the yPosition where the toy robot will be placed
     * @param direction the {@link Direction}
     * @param toyRobot  the toy robot which will perform the actual action
     */
    PlaceCommand(int x, int y, Direction direction, ToyRobot toyRobot) {
        this(new Placement(x, y, direction), toyRobot);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void perform() {
        toyRobot.doPlace(placement);
    }

    @Override
    public String toString() {
        return "PlaceCommand{" +
                "placement=" + placement +
                ", toyRobot=" + toyRobot +
                '}';
    }
}

package com.rea.toyrobot.command;

import com.rea.toyrobot.placement.Direction;
import com.rea.toyrobot.placement.Placement;
import com.rea.toyrobot.robot.ToyRobot;

public final class PlaceCommand implements Command {

    private final Placement placement;
    private final ToyRobot toyRobot;

    PlaceCommand(Placement placement, ToyRobot toyRobot) {
        this.placement = placement;
        this.toyRobot = toyRobot;
    }

    PlaceCommand(int x, int y, Direction direction, ToyRobot toyRobot) {
        this(new Placement(x, y, direction), toyRobot);
    }

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

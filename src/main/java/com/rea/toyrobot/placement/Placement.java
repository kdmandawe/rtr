package com.rea.toyrobot.placement;

/**
 * Model class that holds position and direction of the {@link com.rea.toyrobot.robot.ToyRobot}
 */
public class Placement {

    private final int xPosition;
    private final int yPosition;
    private final Direction direction;

    public Placement(int xPosition, int yPosition, Direction direction) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.direction = direction;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Placement placement = (Placement) o;

        return xPosition == placement.xPosition && yPosition == placement.yPosition && direction == placement.direction;
    }

    @Override
    public int hashCode() {
        int result = xPosition;
        result = 31 * result + yPosition;
        result = 31 * result + direction.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Placement{" +
                "xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                ", direction=" + direction +
                '}';
    }
}

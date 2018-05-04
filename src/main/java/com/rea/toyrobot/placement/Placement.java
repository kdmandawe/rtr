package com.rea.toyrobot.placement;

/**
 * Model class that holds position and direction of the {@link com.rea.toyrobot.robot.ToyRobot}
 */
public class Placement {

    private int xPosition;
    private int yPosition;
    private Direction direction;

    public Placement(int xPosition, int yPosition, Direction direction) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.direction = direction;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Placement placement = (Placement) o;

        if (xPosition != placement.xPosition) return false;
        if (yPosition != placement.yPosition) return false;
        return direction == placement.direction;
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

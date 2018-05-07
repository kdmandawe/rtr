package com.rea.toyrobot.robot;

import com.rea.toyrobot.placement.Direction;
import com.rea.toyrobot.placement.Placement;
import com.rea.toyrobot.tabletop.TableTop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.rea.toyrobot.placement.Direction.*;
import static com.rea.toyrobot.robot.TurnDirection.LEFT;

/**
 * This class represents a Basic Toy Robot. This kind of robot can only understand basic commands
 * such as 'PLACE X,Y,F', 'MOVE', 'LEFT', 'RIGHT', and 'REPORT'. These commands are translated
 * to the corresponding actions as defined in the {@link ToyRobot}
 */
public class BasicToyRobot implements ToyRobot {

    private static final Logger LOG = LoggerFactory.getLogger(BasicToyRobot.class);

    private final TableTop tableTop;
    private Placement placement;
    private boolean inPlay;

    /**
     * Instantiates a new Basic toy robot.
     *
     * @param tableTop the table top where the robot will do the command actions
     */
    BasicToyRobot(TableTop tableTop) {
        this.tableTop = tableTop;
        this.inPlay = false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Placement getPlacement() {
        return placement;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean inPlay() {
        return inPlay;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doPlace(Placement newPlacement) {
        LOG.debug("Executing PLACE Command..");
        if(actionValid(newPlacement)) {
            placement = newPlacement;
            inPlay = true;
        } else {
            LOG.warn("Invalid PLACE Command. Ignoring..");
        }
        LOG.debug("Current: {}", placement);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doMove() {
        LOG.debug("Executing MOVE Command..");
        if(inPlay) {
            int newX = placement.getxPosition();
            int newY = placement.getyPosition();

            switch (placement.getDirection()) {
                case NORTH:
                    newY++;
                    break;
                case SOUTH:
                    newY--;
                    break;
                case EAST:
                    newX++;
                    break;
                case WEST:
                    newX--;
                    break;
            }
            Placement newPlacement = new Placement(newX, newY, placement.getDirection());
            if (actionValid(newPlacement)) {
                placement = newPlacement;
            } else {
                LOG.warn("Invalid MOVE Command. Ignoring..");
            }
        } else {
            LOG.warn("Toy Robot not in play yet. Ignoring MOVE Command..");
        }

        LOG.debug("Current: {}", placement != null ? placement : "Not In Play");

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doTurn(TurnDirection direction) {
        LOG.debug("Executing {} Command..", direction);
        if(inPlay) {
            Direction newDirection = placement.getDirection();
            switch (placement.getDirection()) {
                case NORTH:
                    newDirection = (direction == LEFT ? WEST : EAST);
                    break;
                case SOUTH:
                    newDirection = (direction == LEFT ? EAST : WEST);
                    break;
                case EAST:
                    newDirection = (direction == LEFT ? NORTH : SOUTH);
                    break;
                case WEST:
                    newDirection = (direction == LEFT ? SOUTH : NORTH);
                    break;
            }
            placement = new Placement(placement.getxPosition(), placement.getyPosition(), newDirection);

        } else {
            LOG.warn("Toy Robot not in play yet. Ignoring {} Command..", direction);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doReport() {
        LOG.debug("Executing REPORT Command..");
        if(placement != null) {
            LOG.info("{},{},{}", placement.getxPosition(), placement.getyPosition(), placement.getDirection());
        } else {
            LOG.info("Toy Robot not in play.");
        }
    }

    private boolean actionValid(Placement newPlacement) {
        boolean valid = true;
        boolean invalidX = newPlacement.getxPosition() < 0 || newPlacement.getxPosition() > tableTop.getMaxXPosition();
        boolean invalidY = newPlacement.getyPosition() < 0 || newPlacement.getyPosition() > tableTop.getMaxYPosition();
        boolean robotWillFall =  invalidX || invalidY ;
        if(!tableTop.allowFall() && robotWillFall) {
            valid = false;
        }
        return valid;
    }
}

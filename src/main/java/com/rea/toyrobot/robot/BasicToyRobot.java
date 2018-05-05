package com.rea.toyrobot.robot;

import com.rea.toyrobot.placement.Direction;
import com.rea.toyrobot.placement.Placement;
import com.rea.toyrobot.tabletop.TableTop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.rea.toyrobot.placement.Direction.*;
import static com.rea.toyrobot.robot.TurnDirection.LEFT;

public class BasicToyRobot implements ToyRobot {

    private static final Logger LOG = LoggerFactory.getLogger(BasicToyRobot.class);

    private TableTop tableTop;
    private Placement placement;
    private boolean inPlay;

    BasicToyRobot(TableTop tableTop) {
        this.tableTop = tableTop;
        this.inPlay = false;
    }

    @Override
    public Placement getPlacement() {
        return placement;
    }

    @Override
    public boolean inPlay() {
        return inPlay;
    }

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

            Placement newPlacement = new Placement(placement.getxPosition(), placement.getyPosition(), newDirection);
            if (actionValid(newPlacement)) {
                placement = newPlacement;
            } else {
                LOG.warn("Invalid {} Command. Ignoring..", direction);
            }
        } else {
            LOG.warn("Toy Robot not in play yet. Ignoring {} Command..", direction);
        }
    }

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

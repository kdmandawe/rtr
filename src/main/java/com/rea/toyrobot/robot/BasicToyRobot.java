package com.rea.toyrobot.robot;

import com.rea.toyrobot.placement.Placement;
import com.rea.toyrobot.tabletop.TableTop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    }

    @Override
    public void doTurn(TurnDirection direction) {

    }

    @Override
    public void doReport() {

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

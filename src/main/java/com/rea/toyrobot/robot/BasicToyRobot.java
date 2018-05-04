package com.rea.toyrobot.robot;

import com.rea.toyrobot.placement.Placement;
import com.rea.toyrobot.tabletop.TableTop;

public class BasicToyRobot implements ToyRobot {

    private TableTop tableTop;
    private Placement placement;
    private boolean inPlay;

    public BasicToyRobot(TableTop tableTop) {
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
    public void doPlace(Placement placement) {

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
}

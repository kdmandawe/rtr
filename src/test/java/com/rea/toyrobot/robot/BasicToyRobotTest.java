package com.rea.toyrobot.robot;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;
import com.rea.toyrobot.placement.Direction;
import com.rea.toyrobot.placement.Placement;
import com.rea.toyrobot.tabletop.TableTop;
import com.rea.toyrobot.tabletop.TableTops;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.slf4j.LoggerFactory;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

public class BasicToyRobotTest {

    private TableTop tableTop;

    @Before
    public void setUp() {
        tableTop = TableTops.newSquareTableTopDontAllowFall(5,5);
    }

    @Test
    public void testCreateBasicToyRobot() {
        BasicToyRobot toyRobot = new BasicToyRobot(tableTop);
        assertNotNull(toyRobot);
        assertFalse(toyRobot.inPlay());
    }

    @Test
    public void testValidPlacement() {
        BasicToyRobot toyRobot = new BasicToyRobot(tableTop);
        toyRobot.doPlace(new Placement(0, 0, Direction.NORTH));
        assertTrue(toyRobot.inPlay());
        Placement currentPlacement = toyRobot.getPlacement();
        assertEquals(0, currentPlacement.getxPosition());
        assertEquals(0, currentPlacement.getyPosition());
        assertEquals(Direction.NORTH, currentPlacement.getDirection());
    }

    @Test
    public void testInvalidPlacement() {
        BasicToyRobot toyRobot = new BasicToyRobot(tableTop);
        toyRobot.doPlace(new Placement(-1, 0, Direction.NORTH));
        assertFalse(toyRobot.inPlay());
        Placement currentPlacement = toyRobot.getPlacement();
        assertNull(currentPlacement);
    }

    @Test
    public void testValidMove() {
        BasicToyRobot toyRobot = new BasicToyRobot(tableTop);
        toyRobot.doPlace(new Placement(0, 0, Direction.NORTH));
        toyRobot.doMove();
        assertTrue(toyRobot.inPlay());
        Placement currentPlacement = toyRobot.getPlacement();
        assertEquals(0, currentPlacement.getxPosition());
        assertEquals(1, currentPlacement.getyPosition());
        assertEquals(Direction.NORTH, currentPlacement.getDirection());
    }

    @Test
    public void testInvalidMove() {
        BasicToyRobot toyRobot = new BasicToyRobot(tableTop);
        toyRobot.doPlace(new Placement(0, 0, Direction.WEST));
        toyRobot.doMove();
        assertTrue(toyRobot.inPlay());
        Placement currentPlacement = toyRobot.getPlacement();
        assertEquals(0, currentPlacement.getxPosition());
        assertEquals(0, currentPlacement.getyPosition());
        assertEquals(Direction.WEST, currentPlacement.getDirection());
    }

    @Test
    public void testMoveRobotNotInPlay() {
        BasicToyRobot toyRobot = new BasicToyRobot(tableTop);
        toyRobot.doMove();
        assertFalse(toyRobot.inPlay());
        Placement currentPlacement = toyRobot.getPlacement();
        assertNull(currentPlacement);
    }

    @Test
    public void testTurnRight() {
        BasicToyRobot toyRobot = new BasicToyRobot(tableTop);
        toyRobot.doPlace(new Placement(0, 0, Direction.NORTH));
        toyRobot.doTurn(TurnDirection.RIGHT);
        assertTrue(toyRobot.inPlay());
        Placement currentPlacement = toyRobot.getPlacement();
        assertEquals(0, currentPlacement.getxPosition());
        assertEquals(0, currentPlacement.getyPosition());
        assertEquals(Direction.EAST, currentPlacement.getDirection());
    }

    @Test
    public void testTurnLeft() {
        BasicToyRobot toyRobot = new BasicToyRobot(tableTop);
        toyRobot.doPlace(new Placement(0, 0, Direction.NORTH));
        toyRobot.doTurn(TurnDirection.LEFT);
        assertTrue(toyRobot.inPlay());
        Placement currentPlacement = toyRobot.getPlacement();
        assertEquals(0, currentPlacement.getxPosition());
        assertEquals(0, currentPlacement.getyPosition());
        assertEquals(Direction.WEST, currentPlacement.getDirection());
    }

    @Test
    public void testTurnLeftNotInplay() {
        BasicToyRobot toyRobot = new BasicToyRobot(tableTop);
        toyRobot.doTurn(TurnDirection.LEFT);
        assertFalse(toyRobot.inPlay());
        Placement currentPlacement = toyRobot.getPlacement();
        assertNull(currentPlacement);
    }

    @Test
    public void testMoveMaxX() {
        BasicToyRobot toyRobot = new BasicToyRobot(tableTop);
        toyRobot.doPlace(new Placement(4, 0, Direction.EAST));
        toyRobot.doMove();
        assertTrue(toyRobot.inPlay());
        Placement currentPlacement = toyRobot.getPlacement();
        assertEquals(4, currentPlacement.getxPosition());
        assertEquals(0, currentPlacement.getyPosition());
        assertEquals(Direction.EAST, currentPlacement.getDirection());
    }

    @Test
    public void testMoveMaxY() {
        BasicToyRobot toyRobot = new BasicToyRobot(tableTop);
        toyRobot.doPlace(new Placement(2, 4, Direction.NORTH));
        toyRobot.doMove();
        assertTrue(toyRobot.inPlay());
        Placement currentPlacement = toyRobot.getPlacement();
        assertEquals(2, currentPlacement.getxPosition());
        assertEquals(4, currentPlacement.getyPosition());
        assertEquals(Direction.NORTH, currentPlacement.getDirection());
    }

    @Test
    public void testDoReportLogConsoleNoError() {

        //setup mock appender
        ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(ch.qos.logback.classic.Logger.ROOT_LOGGER_NAME);
        final Appender mockAppender = mock(Appender.class);
        when(mockAppender.getName()).thenReturn("MOCK");
        root.addAppender(mockAppender);

        BasicToyRobot toyRobot = new BasicToyRobot(tableTop);
        toyRobot.doPlace(new Placement(0, 0, Direction.NORTH));
        toyRobot.doReport();
        //Check if report is logged
        verify(mockAppender).doAppend(argThat((ArgumentMatcher) argument -> ((LoggingEvent)argument).getFormattedMessage().contains("0,0,NORTH")));

        toyRobot.doMove();
        toyRobot.doReport();
        //Check if report is logged
        verify(mockAppender).doAppend(argThat((ArgumentMatcher) argument -> ((LoggingEvent)argument).getFormattedMessage().contains("0,1,NORTH")));

        toyRobot.doPlace(new Placement(2, 2, Direction.NORTH));
        toyRobot.doTurn(TurnDirection.LEFT);
        toyRobot.doReport();
        //Check if report is logged
        verify(mockAppender).doAppend(argThat((ArgumentMatcher) argument -> ((LoggingEvent)argument).getFormattedMessage().contains("2,2,WEST")));
        // clean up
        root.detachAppender(mockAppender);
    }

}
package com.rea.toyrobot.command;

import com.rea.toyrobot.placement.Direction;
import com.rea.toyrobot.placement.Placement;
import com.rea.toyrobot.robot.ToyRobot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.rea.toyrobot.common.util.Constants.COMMA;
import static com.rea.toyrobot.common.util.Constants.WHITE_SPACE;

/**
 * Factory class for creating {@link Command} instances
 */
public final class Commands {

    private static final Logger LOG = LoggerFactory.getLogger(Commands.class);

    /**
     * @param rawCommand The command string taken from input (per line)
     * @return the appropriate instance of {@link Command}
     */
    public static Command newCommand(final String rawCommand, ToyRobot toyRobot) {
        Command command = null;
        try {
            String[] tokens = rawCommand.trim().split(WHITE_SPACE);
            final KnownCommands key = KnownCommands.fromString(tokens[0]);
            switch (key) {
                case PLACE:
                    Placement placement = getPlacement(tokens[1]);
                    command = new PlaceCommand(placement, toyRobot);
                    break;
                case MOVE:
                    command = new MoveCommand(toyRobot);
                    break;
                case LEFT:
                    command = new LeftCommand(toyRobot);
                    break;
                case RIGHT:
                    command = new RightCommand(toyRobot);
                    break;
                case REPORT:
                    command = new ReportCommand(toyRobot);
                    break;
            }
        } catch (Exception e) {
            LOG.error("Ivalid command: '{}'. Ignoring command...", rawCommand);
        }
        return command;
    }

    private static Placement getPlacement(String rawPlacementString) {
        String[] tokens = rawPlacementString.split(COMMA);
        int xPos = Integer.parseInt(tokens[0]);
        int yPos = Integer.parseInt(tokens[1]);
        Direction direction = Direction.fromString(tokens[2]);
        return new Placement(xPos, yPos, direction);
    }
}

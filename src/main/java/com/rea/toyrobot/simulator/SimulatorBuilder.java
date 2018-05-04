package com.rea.toyrobot.simulator;

import com.rea.toyrobot.input.InputHandler;
import com.rea.toyrobot.robot.ToyRobot;
import com.rea.toyrobot.tabletop.TableTop;

/**
 * A Step Builder Class that provides convenient way to build the {@link ToyRobotSimulator}
 */
public class SimulatorBuilder {

    public static InputHandlerStep newBuilder() {
        return new CreationSteps();
    }

    public static interface InputHandlerStep {
        /**
         * @param inputHandler
         *          the {@link InputHandler} to be used for reading input by the simulator
         * @return
         *          ToyRobotStep
         */
        ToyRobotStep inputHandler(InputHandler inputHandler);
    }

    public static interface ToyRobotStep {
        /**
         * @param toyRobot
         *          the {@link ToyRobot} that will execute the commands
         * @return
         *          TableTopStep
         */
        TableTopStep toyRobot(ToyRobot toyRobot);
    }

    public static interface TableTopStep {
        /**
         * @param tableTop
         *          the {@link TableTop} that will be used to place the ToyRobot to
         * @return
         *          BuildStep
         */
        BuildStep tableTop(TableTop tableTop);
    }

    public static interface BuildStep {
        /**
         * @return an instance of {@link ToyRobotSimulator} based on the parameters passed during the creation.
         */
        ToyRobotSimulator build();
    }

    private static class CreationSteps implements InputHandlerStep, ToyRobotStep , TableTopStep, BuildStep {

        private InputHandler inputHandler;
        private ToyRobot toyRobot;
        private TableTop tableTop;

        @Override
        public ToyRobotStep inputHandler(InputHandler inputHandler) {
            this.inputHandler = inputHandler;
            return this;
        }

        @Override
        public TableTopStep toyRobot(ToyRobot toyRobot) {
            this.toyRobot = toyRobot;
            return this;
        }

        @Override
        public BuildStep tableTop(TableTop tableTop) {
            this.tableTop = tableTop;
            return this;
        }

        @Override
        public ToyRobotSimulator build() {
            return new ToyRobotSimulator(inputHandler, toyRobot, tableTop);
        }
    }
}

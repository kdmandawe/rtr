package com.rea.toyrobot.simulator;

import com.rea.toyrobot.input.InputHandler;
import com.rea.toyrobot.robot.ToyRobot;
import com.rea.toyrobot.robot.ToyRobots;
import com.rea.toyrobot.tabletop.TableTop;

/**
 * A Step Builder Class that provides convenient way to build the {@link ToyRobotSimulator}
 */
public class SimulatorBuilder {

    public static InputHandlerStep newBuilder() {
        return new CreationSteps();
    }

    public interface InputHandlerStep {
        /**
         * @param inputHandler
         *          the {@link InputHandler} to be used for reading input by the simulator
         * @return
         *          ToyRobotStep
         */
        TableTopStep inputHandler(InputHandler inputHandler);
    }

    public interface TableTopStep {
        /**
         * @param tableTop
         *          the {@link TableTop} that will be used to place the ToyRobot to
         * @return
         *          BuildStep
         */
        ToyRobotStep tableTop(TableTop tableTop);
    }

    public interface ToyRobotStep {
        /**
         * @return
         *          BuildStep
         */
        BuildStep basicToyRobot();
    }



    public interface BuildStep {
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
        public TableTopStep inputHandler(InputHandler inputHandler) {
            this.inputHandler = inputHandler;
            return this;
        }

        @Override
        public ToyRobotStep tableTop(TableTop tableTop) {
            this.tableTop = tableTop;
            return this;
        }

        @Override
        public BuildStep basicToyRobot() {
            this.toyRobot = ToyRobots.newBasicToyRobot(tableTop);
            return this;
        }


        @Override
        public ToyRobotSimulator build() {
            return new ToyRobotSimulator(inputHandler, toyRobot);
        }
    }
}

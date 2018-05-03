package com.rea.toyrobot.input;

import com.rea.toyrobot.command.Command;
import com.rea.toyrobot.command.Commands;
import com.rea.toyrobot.common.exception.SimulatorException;
import com.rea.toyrobot.robot.ToyRobot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FileInputHandler implements InputHandler {

    private static final Logger LOG = LoggerFactory.getLogger(FileInputHandler.class);

    @Override
    public Optional<List<Command>> getCommands(String[] inputArgs, ToyRobot toyRobot) {
        List<Command> commands;
        if (inputArgs == null || inputArgs.length < 1) {
            throw new IllegalArgumentException("Missing filename input!");
        }

        try {
            URL url = getClass().getClassLoader().getResource(inputArgs[0]);
            List<String> inputRawCommands = Files.readAllLines(Paths.get(url.toURI()));
            commands = inputRawCommands.stream()
                    .map(str -> Commands.newCommand(str, toyRobot))
                    .filter(cmd -> cmd != null)
                    .collect(Collectors.toList());

        } catch (IOException | URISyntaxException e) {
            LOG.error("Could not read input: " + e.getMessage());
            throw new SimulatorException("Error with reading from file", e);
        }
        return Optional.ofNullable(commands);
    }
}

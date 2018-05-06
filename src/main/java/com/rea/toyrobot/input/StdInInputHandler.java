package com.rea.toyrobot.input;

import com.rea.toyrobot.command.Command;
import com.rea.toyrobot.command.Commands;
import com.rea.toyrobot.robot.ToyRobot;

import java.util.*;
import java.util.stream.Collectors;

public class StdInInputHandler implements InputHandler {

    @Override
    public Optional<List<Command>> getCommands(String[] inputArgs, ToyRobot toyRobot) {
        List<Command> commands;
        if (inputArgs != null && inputArgs.length > 0) {
            throw new IllegalArgumentException("Input argument detected.. You might need a FileInputHandler instead " +
                    "of a StdInInputHandler!");
        }

        List<String> inputRawCommands = new ArrayList<>();

        System.out.println("Enter the commands(one per line).");
        System.out.println("To end, input 'q!'");
        System.out.println();

        try(Scanner scanner = new Scanner(System.in)) {
            String input;
            while (scanner.hasNext()) {
                input = scanner.nextLine();
                if ("q!".equals(input)) {
                    break;
                }
                inputRawCommands.add(input);
            }
        }
        System.out.println("Set of commands now complete!");

        commands = inputRawCommands.stream()
                .map(str -> Commands.newCommand(str, toyRobot))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return Optional.ofNullable(commands);
    }

    public static void main(String[] args) {
        StdInInputHandler std = new StdInInputHandler();
        std.getCommands(null, null);
    }
}

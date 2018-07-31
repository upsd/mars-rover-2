package upsd.input_and_output;

import upsd.commands.Command;
import upsd.commands.LeftCommand;
import upsd.commands.MoveCommand;
import upsd.commands.RightCommand;
import upsd.domain.Grid;
import upsd.domain.Point;
import upsd.domain.Rover;
import upsd.headings.Heading;
import upsd.headings.HeadingConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public ParserResult parse(String input) {
        Grid grid = parseGridFrom(input);
        List<List<Command>> commands = parseCommandsFrom(input, grid);
        List<Rover> rovers = parseRoversFrom(input, grid);

        LinkedHashMap<Rover, List<Command>> roverAndCommands = new LinkedHashMap<>();

        rovers.stream().forEach(rover -> {
            int currentIndex = rovers.indexOf(rover);
            roverAndCommands.put(rover, commands.get(currentIndex));
        });

        return new ParserResult(roverAndCommands);
    }

    private Grid parseGridFrom(String input) {
        String[] upperRightCoordinates = input.split("\n")[0].split(" ");

        int x = Integer.parseInt(upperRightCoordinates[0]);
        int y = Integer.parseInt(upperRightCoordinates[1]);

        return new Grid(new Point(x, y));
    }

    private List<Rover> parseRoversFrom(String input, Grid grid) {
        HeadingConverter converter = new HeadingConverter();
        String[] splittedInput = input.split("\n");

        List<Rover> rovers = new ArrayList<>();

        for (int i = 1; i < splittedInput.length; i+=2) {
            String[] startingPosition = splittedInput[i].split(" ");

            int x = Integer.parseInt(startingPosition[0]);
            int y = Integer.parseInt(startingPosition[1]);
            Heading heading = converter.toHeading(startingPosition[2]);

            rovers.add(new Rover(new Point(x, y), heading, grid));
        }

        return rovers;
    }

    private List<List<Command>> parseCommandsFrom(String input, Grid grid) {
        String[] splittedInput = input.split("\n");

        List<List<Command>> commandsToReturn = new ArrayList<>();

        for (int i = 2; i < splittedInput.length; i+=2) {
            String[] commands = splittedInput[i].split("");

            List<Command> commandsToAdd = Arrays.stream(commands)
                    .map(c -> getCommandFromAbbreviation(c, grid))
                    .collect(Collectors.toList());
            commandsToReturn.add(commandsToAdd);
        }
        return commandsToReturn;
    }

    private Command getCommandFromAbbreviation(String command, Grid grid) {
        if (command.equals("L")) {
            return new LeftCommand();
        }
        if (command.equals("R")) {
            return new RightCommand();
        }

        return new MoveCommand(grid);
    }
}

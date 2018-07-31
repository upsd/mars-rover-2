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
        String[] dividedInput = divideInputByNewLine(input);

        Grid grid = parseGridFrom(dividedInput);
        List<List<Command>> commands = parseCommandsFrom(dividedInput);
        List<Rover> rovers = parseRoversFrom(dividedInput, grid);

        LinkedHashMap<Rover, List<Command>> roverAndCommands = combineRoversAndCommands(commands, rovers);;

        return new ParserResult(roverAndCommands);
    }

    private Grid parseGridFrom(String[] input) {
        String[] upperRightCoordinates = input[0].split(" ");

        int x = Integer.parseInt(upperRightCoordinates[0]);
        int y = Integer.parseInt(upperRightCoordinates[1]);

        return new Grid(new Point(x, y));
    }

    private List<Rover> parseRoversFrom(String[] input, Grid grid) {
        HeadingConverter converter = new HeadingConverter();

        List<Rover> rovers = new ArrayList<>();

        int INDEX_OF_ROVERS = 1;
        int NUMBER_OF_PARTS_TO_SKIP = 2;
        for (int i = INDEX_OF_ROVERS; i < input.length; i += NUMBER_OF_PARTS_TO_SKIP) {
            String[] startingPosition = input[i].split(" ");

            int x = Integer.parseInt(startingPosition[0]);
            int y = Integer.parseInt(startingPosition[INDEX_OF_ROVERS]);
            Heading heading = converter.toHeading(startingPosition[2]);

            rovers.add(new Rover(new Point(x, y), heading, grid));
        }

        return rovers;
    }

    private List<List<Command>> parseCommandsFrom(String[] input) {
        List<List<Command>> commandsToReturn = new ArrayList<>();

        int INDEX_OF_COMMANDS = 2;
        int NUMBER_OF_PARTS_TO_SKIP = 2;
        for (int i = INDEX_OF_COMMANDS; i < input.length; i += NUMBER_OF_PARTS_TO_SKIP) {
            String[] commands = input[i].split("");

            List<Command> commandsToAdd = Arrays.stream(commands)
                    .map(c -> getCommandFromAbbreviation(c))
                    .collect(Collectors.toList());
            commandsToReturn.add(commandsToAdd);
        }
        return commandsToReturn;
    }

    private Command getCommandFromAbbreviation(String command) {
        if (command.equals("L")) {
            return new LeftCommand();
        }
        if (command.equals("R")) {
            return new RightCommand();
        }

        return new MoveCommand();
    }

    private LinkedHashMap<Rover, List<Command>> combineRoversAndCommands(List<List<Command>> commands, List<Rover> rovers) {
        LinkedHashMap<Rover, List<Command>> roverAndCommands = new LinkedHashMap<>();

        rovers.stream().forEach(rover -> {
            int currentIndex = rovers.indexOf(rover);
            roverAndCommands.put(rover, commands.get(currentIndex));
        });

        return roverAndCommands;
    }

    private String[] divideInputByNewLine(String input) {
        return input.split("\n");
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NasaMarsRoverMissionControl {

    private final Grid grid;
    private final List<Rover> rovers;
    private final List<List<Command>> commands;

    public NasaMarsRoverMissionControl(String input, InputParser parser) {
        grid = parser.parseGridFrom(input);
        rovers = parser.parseRoversFrom(input);
        commands = parser.parseCommandsFrom(input, grid);
    }

    public String getFinalCoordinatesAndHeadings() {
        List<Rover> roversPostCommands = executeCommandsAndGetNewRovers();
        HeadingConverter converter = new HeadingConverter();

        return roversPostCommands.stream()
                .map(r -> String.format("%d %d %s", r.x(), r.y(), converter.toAbbreviation(r.heading())))
                .collect(Collectors.joining("\n"));
    }

    private List<Rover> executeCommandsAndGetNewRovers() {
        List<Rover> roversPostCommands = new ArrayList<>();

        commands.stream().forEach(set -> {
            int index = commands.indexOf(set);
            final Rover[] rover = {rovers.get(index)};

            set.stream().forEach(command -> {
                rover[0] = command.execute(rover[0]);
            });
            roversPostCommands.add(rover[0]);
        });
        return roversPostCommands;
    }
}

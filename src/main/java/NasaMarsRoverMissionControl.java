import java.util.List;

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
        return new OutputFormatter().format(executeCommandsAndGetNewRovers());
    }

    private List<Rover> executeCommandsAndGetNewRovers() {
        return new CommandExecutor().executeAll(commands, rovers);
    }
}

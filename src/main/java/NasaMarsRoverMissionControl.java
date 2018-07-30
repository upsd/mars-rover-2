import java.util.List;

public class NasaMarsRoverMissionControl {

    private final Grid grid;
    private final List<Rover> rovers;
    private final List<List<Command>> commands;
    private OutputFormatter formatter;
    private CommandExecutor commandExecutor;

    public NasaMarsRoverMissionControl(String input, InputParser parser, OutputFormatter outputFormatter, CommandExecutor commandExecutor) {
        grid = parser.parseGridFrom(input);
        rovers = parser.parseRoversFrom(input);
        commands = parser.parseCommandsFrom(input, grid);
        formatter = outputFormatter;
        this.commandExecutor = commandExecutor;
    }

    public String getFinalCoordinatesAndHeadings() {
        return formatter.format(executeCommandsAndGetNewRovers());
    }

    private List<Rover> executeCommandsAndGetNewRovers() {
        return commandExecutor.executeAll(commands, rovers);
    }
}

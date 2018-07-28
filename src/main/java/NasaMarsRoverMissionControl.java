import java.util.List;

public class NasaMarsRoverMissionControl {

    private final Grid grid;
    private final List<Rover> rovers;
    private final List<List<Command>> commands;

    public NasaMarsRoverMissionControl(String input, InputParser parser) {
        grid = parser.parseGridFrom(input);
        rovers = parser.parseRoversFrom(input);
        commands = parser.parseCommandsFrom(input);
    }

    public String getFinalCoordinatesAndHeadings() {
        commands.stream().forEach(set -> {
            int index = commands.indexOf(set);
            final Rover[] rover = {rovers.get(index)};

            set.stream().forEach(command -> {
                rover[0] = command.execute(rover[0]);
            });
        });
        return "";
    }
}

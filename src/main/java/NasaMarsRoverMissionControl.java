import java.util.List;

public class NasaMarsRoverMissionControl {

    private final Grid grid;
    private final Rovers rovers;

    public NasaMarsRoverMissionControl(String input, InputParser parser) {
        grid = parser.parseGridFrom(input);
        rovers = parser.parseRoversFrom(input);
        List<CommandSet> commands = parser.parseCommandsFrom(input);
    }

    public String getFinalCoordinatesAndHeadings() {
        return "";
    }
}

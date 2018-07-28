public class NasaMarsRoverMissionControl {

    private final Grid grid;
    private final Rovers rovers;

    public NasaMarsRoverMissionControl(String input, InputParser parser) {
        grid = parser.parseGridFrom(input);
        rovers = parser.parseRoversFrom(input);
    }

    public String getFinalCoordinatesAndHeadings() {
        return "";
    }
}

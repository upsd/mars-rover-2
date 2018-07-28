public class NasaMarsRoverMissionControl {

    private final Grid grid;

    public NasaMarsRoverMissionControl(String input, InputParser parser) {
        grid = parser.parseGridFrom(input);
    }

    public String getFinalCoordinatesAndHeadings() {
        return "";
    }
}

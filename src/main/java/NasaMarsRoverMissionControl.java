public class NasaMarsRoverMissionControl {

    private final Grid grid;

    public NasaMarsRoverMissionControl(String input, InputParser parser) {
        grid = new InputParser().parseGridFrom(input);
    }

    public String getFinalCoordinatesAndHeadings() {
        return "";
    }
}

import java.util.List;

public class InputParser {

    public Grid parseGridFrom(String input) {
        String[] upperRightCoordinates = input.split("\n")[0].split(" ");

        int x = Integer.parseInt(upperRightCoordinates[0]);
        int y = Integer.parseInt(upperRightCoordinates[1]);

        return new Grid(new Point(x, y));
    }

    public List<Rover> parseRoversFrom(String input) {
        return null;
    }

    public List<List<Command>> parseCommandsFrom(String input) {
        return null;
    }
}

public class LeftCommand implements Command {

    @Override
    public Rover execute(Rover rover) {
        Heading newHeading = null;

        if (rover.heading() == Heading.NORTH) {
            newHeading = Heading.WEST;
        }

        if (rover.heading() == Heading.WEST) {
            newHeading = Heading.SOUTH;
        }

        if (rover.heading() == Heading.SOUTH) {
            newHeading = Heading.EAST;
        }

        if (rover.heading() == Heading.EAST) {
            newHeading = Heading.NORTH;
        }
        return new Rover(new Point(rover.x(), rover.y()), newHeading);
    }
}

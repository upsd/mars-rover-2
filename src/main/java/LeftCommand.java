public class LeftCommand implements Command {

    @Override
    public Rover execute(Rover rover) {
        if (rover.heading() == Heading.NORTH) {
            return new Rover(new Point(rover.x(), rover.y()), Heading.WEST);
        }

        if (rover.heading() == Heading.WEST) {
            return new Rover(new Point(rover.x(), rover.y()), Heading.SOUTH);
        }

        if (rover.heading() == Heading.SOUTH) {
            return new Rover(new Point(rover.x(), rover.y()), Heading.EAST);
        }

        if (rover.heading() == Heading.EAST) {
            return new Rover(new Point(rover.x(), rover.y()), Heading.NORTH);
        }
        return rover;
    }
}

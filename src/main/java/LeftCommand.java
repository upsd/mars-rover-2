public class LeftCommand implements Command {

    @Override
    public Rover execute(Rover rover) {
        if (rover.heading() == Heading.NORTH) {
            return new Rover(new Point(rover.x(), rover.y()), Heading.WEST);
        }
        return rover;
    }
}

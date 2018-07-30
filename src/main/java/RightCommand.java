public class RightCommand implements Command {

    @Override
    public Rover execute(Rover rover) {
        return new Rover(new Point(rover.x(), rover.y()), rover.heading().turnRight());
    }
}

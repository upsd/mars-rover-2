public class MoveCommand implements Command {

    private Grid grid;

    public MoveCommand(Grid grid) {
        this.grid = grid;
    }

    @Override
    public Rover execute(Rover rover) {
        Point newPoint = rover.heading().move(new Point(rover.x(), rover.y()));
        return new Rover(this.grid.sanitisePoint(newPoint), rover.heading());
    }
}

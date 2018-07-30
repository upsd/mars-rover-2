public class MoveCommand implements Command {

    private Grid grid;

    public MoveCommand(Grid grid) {
        this.grid = grid;
    }

    @Override
    public Rover execute(Rover rover) {
        int newX = rover.x();
        int newY = rover.y();

        if (rover.heading() == Heading.NORTH) {
            newY += 1;
        }
        if (rover.heading() == Heading.EAST) {
            newX += 1;
        }
        if (rover.heading() == Heading.SOUTH) {
            newY -= 1;
        }
        if (rover.heading() == Heading.WEST) {
            newX -= 1;
        }

        return new Rover(new Point(normaliseXCoordinate(newX), normaliseYCoordinate(newY)), rover.heading());
    }

    private int normaliseXCoordinate(int coordinate) {
        return this.grid.validateXCoordinate(coordinate);
    }

    private int normaliseYCoordinate(int coordinate) {
        return this.grid.validateYCoordinate(coordinate);
    }
}

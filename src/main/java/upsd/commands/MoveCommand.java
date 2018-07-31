package upsd.commands;

import upsd.domain.Grid;
import upsd.domain.Rover;

public class MoveCommand implements Command {

    private Grid grid;

    public MoveCommand(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void execute(Rover rover) {
        rover.move();
//        return new Rover(this.grid.sanitisePoint(newPoint), rover.heading());
    }
}

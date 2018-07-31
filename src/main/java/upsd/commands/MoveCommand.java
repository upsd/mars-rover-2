package upsd.commands;

import upsd.domain.Rover;

public class MoveCommand implements Command {

    @Override
    public void execute(Rover rover) {
        rover.move();
    }
}

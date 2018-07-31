package upsd.commands;

import upsd.domain.Rover;

public class RightCommand implements Command {

    @Override
    public void execute(Rover rover) {
        rover.turnRight();
    }
}

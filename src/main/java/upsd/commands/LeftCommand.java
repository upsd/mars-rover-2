package upsd.commands;

import upsd.domain.Rover;

public class LeftCommand implements Command {

    @Override
    public void execute(Rover rover) {
        rover.turnLeft();
//        return new Rover(new Point(rover.x(), rover.y()), rover.turnLeft());
    }
}

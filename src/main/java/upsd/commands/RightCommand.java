package upsd.commands;

import upsd.domain.Rover;

public class RightCommand implements Command {

    @Override
    public void execute(Rover rover) {
        rover.turnRight();
//        return new Rover(new Point(rover.x(), rover.y()), rover.turnRight());
    }
}

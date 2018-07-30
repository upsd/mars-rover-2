package upsd.commands;

import upsd.domain.Point;
import upsd.domain.Rover;

public class LeftCommand implements Command {

    @Override
    public Rover execute(Rover rover) {
        return new Rover(new Point(rover.x(), rover.y()), rover.heading().turnLeft());
    }
}

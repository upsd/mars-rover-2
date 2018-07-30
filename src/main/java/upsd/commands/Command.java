package upsd.commands;

import upsd.domain.Rover;

public interface Command {

    Rover execute(Rover rover);
}

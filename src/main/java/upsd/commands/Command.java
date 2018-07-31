package upsd.commands;

import upsd.domain.Rover;

public interface Command {

    void execute(Rover rover);
}

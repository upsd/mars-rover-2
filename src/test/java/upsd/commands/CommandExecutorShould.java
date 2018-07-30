package upsd.commands;

import org.junit.jupiter.api.Test;
import upsd.domain.Grid;
import upsd.domain.Point;
import upsd.domain.Rover;
import upsd.headings.HeadingEast;
import upsd.headings.HeadingNorth;
import upsd.headings.HeadingWest;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CommandExecutorShould {

    @Test
    void execute_batch_of_commands() {
        CommandExecutor executor = new CommandExecutor();

        List<Rover> rovers = Arrays.asList(
                new Rover(new Point(4, 3), new HeadingNorth()),
                new Rover(new Point(5, 3), new HeadingEast())
        );
        Grid grid = new Grid(new Point(10, 10));
        List<List<Command>> commands = asList(
                asList(
                        new LeftCommand(),
                        new MoveCommand(grid)
                ),
                asList(
                        new MoveCommand(grid),
                        new MoveCommand(grid)
                )
        );

        List<Rover> newRovers = executor.executeAll(commands, rovers);

        Rover firstRover = newRovers.get(0);
        assertTrue(firstRover.heading() instanceof HeadingWest);
        assertThat(firstRover.x(), is(3));
        assertThat(firstRover.y(), is(3));

        Rover secondRover = newRovers.get(1);
        assertTrue(secondRover.heading() instanceof HeadingEast);
        assertThat(secondRover.x(), is(7));
        assertThat(secondRover.y(), is(3));
    }
}

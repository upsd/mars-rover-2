import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CommandExecutorShould {

    @Test
    void execute_batch_of_commands() {
        CommandExecutor executor = new CommandExecutor();

        List<Rover> rovers = Arrays.asList(
                new Rover(new Point(4, 3), Heading.NORTH),
                new Rover(new Point(5, 3), Heading.EAST)
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
        assertThat(firstRover.heading(), is(Heading.WEST));
        assertThat(firstRover.x(), is(3));
        assertThat(firstRover.y(), is(3));

        Rover secondRover = newRovers.get(1);
        assertThat(secondRover.heading(), is(Heading.EAST));
        assertThat(secondRover.x(), is(7));
        assertThat(secondRover.y(), is(3));
    }
}

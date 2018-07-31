package upsd.commands;

import org.junit.jupiter.api.Test;
import upsd.domain.Grid;
import upsd.domain.Point;
import upsd.domain.Rover;
import upsd.headings.HeadingNorth;
import upsd.headings.HeadingWest;
import upsd.input_and_output.ParserResult;

import java.util.LinkedHashMap;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CommandExecutorShould {

    @Test
    void execute_batch_of_commands() {
        CommandExecutor executor = new CommandExecutor();

        LinkedHashMap<Rover, List<Command>> roversAndCommands = new LinkedHashMap<>();
        roversAndCommands.put(
                new Rover(new Point(4, 3), new HeadingNorth()),
                asList(
                        new LeftCommand(),
                        new MoveCommand(new Grid(new Point(10, 10)))
                )
        );
        ParserResult result = new ParserResult(roversAndCommands);


        List<Rover> newRovers = executor.executeAll(result);

        Rover firstRover = newRovers.get(0);
        assertTrue(firstRover.heading() instanceof HeadingWest);
        assertThat(firstRover.x(), is(3));
        assertThat(firstRover.y(), is(3));
    }
}

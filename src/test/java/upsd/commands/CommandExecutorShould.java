package upsd.commands;

import org.junit.jupiter.api.Test;
import upsd.domain.Grid;
import upsd.domain.Point;
import upsd.domain.Rover;
import upsd.headings.HeadingNorth;
import upsd.input_and_output.ParserResult;

import java.util.LinkedHashMap;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CommandExecutorShould {

    @Test
    void execute_batch_of_commands() {
        CommandExecutor executor = new CommandExecutor();

        LinkedHashMap<Rover, List<Command>> roversAndCommands = new LinkedHashMap<>();
        Grid grid = new Grid(new Point(10, 10));
        Rover rover = new Rover(new Point(4, 3), new HeadingNorth(), grid);
        roversAndCommands.put(
                rover,
                asList(
                        new LeftCommand(),
                        new MoveCommand()
                )
        );
        ParserResult result = new ParserResult(roversAndCommands);


        executor.executeAll(result);

        assertThat(rover.x(), is(3));
        assertThat(rover.y(), is(3));
    }
}

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class InputParserShould {

    private InputParser parser = new InputParser();

    @Test
    void parse_grid_from_input() {
        Grid grid = parser.parseGridFrom("5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM");

        assertThat(grid, is(notNullValue()));
    }

    @Test
    void parse_rovers_from_input() {
        List<Rover> rovers = parser.parseRoversFrom("5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM");

        assertThat(rovers.size(), is(2));
    }

    @Test
    void parse_commands_from_input() {
        List<List<Command>> commands = parser.parseCommandsFrom("5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM", null);

        assertThat(commands.size(), is(2));
    }
}

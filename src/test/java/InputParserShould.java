import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class InputParserShould {

    @Test
    public void parse_grid_from_input() {
        InputParser parser = new InputParser();

        Grid grid = parser.parseGridFrom("5 5\n");

        assertThat(grid.upperRightX(), is(5));
        assertThat(grid.upperRightY(), is(5));
    }
}

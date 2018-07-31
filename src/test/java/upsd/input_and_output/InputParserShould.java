package upsd.input_and_output;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InputParserShould {

    @Test
    void parse_everything_from_input() {
        InputParser parser = new InputParser();

        ParserResult result = parser.parse("5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM");

        assertThat(result.roverAndCommands().size(), is(2));
    }
}

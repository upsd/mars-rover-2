package upsd.input_and_output;

import org.junit.jupiter.api.Test;
import upsd.domain.Point;
import upsd.domain.Rover;
import upsd.headings.HeadingEast;
import upsd.headings.HeadingNorth;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OutputFormatterShould {

    @Test
    void format_rovers_in_correct_format() {
        OutputFormatter formatter = new OutputFormatter();
        List<Rover> rovers = Arrays.asList(
                new Rover(new Point(1, 1), new HeadingNorth(), null),
                new Rover(new Point(5, 3), new HeadingEast(), null)
        );

        String output = formatter.format(rovers);

        assertThat(output, is("1 1 N\n5 3 E"));
    }
}

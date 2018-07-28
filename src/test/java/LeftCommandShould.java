import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LeftCommandShould {

    @ParameterizedTest
    @MethodSource("headingProvider")
    public void change_heading_if_rover_is_facing_north(Heading currentHeading, Heading expectedHeading) {
        Rover rover = new Rover(new Point(1, 1), currentHeading);
        LeftCommand command = new LeftCommand();

        Rover newRover = command.execute(rover);

        assertThat(newRover.heading(), is(expectedHeading));
    }

    static Stream<Arguments> headingProvider() {
        return Stream.of(
                Arguments.of(Heading.NORTH, Heading.WEST),
                Arguments.of(Heading.WEST, Heading.SOUTH),
                Arguments.of(Heading.SOUTH, Heading.EAST),
                Arguments.of(Heading.EAST, Heading.NORTH)
        );
    }
}

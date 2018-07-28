import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RightCommandShould {

    @ParameterizedTest
    @MethodSource("headingProvider")
    void change_heading_of_rover_after_turning(Heading currentHeading, Heading expectedHeading) {
        Rover rover = new Rover(new Point(1, 1), currentHeading);
        RightCommand command = new RightCommand();

        Rover newRover = command.execute(rover);

        assertThat(newRover.heading(), is(expectedHeading));
    }

    static Stream<Arguments> headingProvider() {
        return Stream.of(
                Arguments.of(Heading.NORTH, Heading.EAST),
                Arguments.of(Heading.EAST, Heading.SOUTH),
                Arguments.of(Heading.SOUTH, Heading.WEST),
                Arguments.of(Heading.WEST, Heading.NORTH)
        );
    }
}

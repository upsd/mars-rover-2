import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LeftCommandShould {

    @Test
    public void change_heading_of_rover_ninety_degrees_left() {
        Rover rover = new Rover(new Point(1, 1), Heading.NORTH);
        LeftCommand command = new LeftCommand();

        Rover newRover = command.execute(rover);

        assertThat(newRover.heading(), is(Heading.WEST));
    }
}

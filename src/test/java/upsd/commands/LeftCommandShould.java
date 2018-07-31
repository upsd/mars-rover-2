package upsd.commands;

import org.junit.jupiter.api.Test;
import upsd.domain.Point;
import upsd.domain.Rover;
import upsd.headings.HeadingNorth;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LeftCommandShould {

    @Test
    public void turn_rover_left() {
        HeadingNorth heading = mock(HeadingNorth.class);
        Rover rover = new Rover(new Point(1, 1), heading, null);
        LeftCommand command = new LeftCommand();

        command.execute(rover);

        verify(heading).turnLeft();
    }
}

package upsd.commands;

import org.junit.jupiter.api.Test;
import upsd.domain.Point;
import upsd.domain.Rover;
import upsd.headings.HeadingNorth;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RightCommandShould {

    @Test
    void turn_rover_right() {
        HeadingNorth heading = mock(HeadingNorth.class);
        Rover rover = new Rover(new Point(1, 1), heading);
        RightCommand command = new RightCommand();

        command.execute(rover);

        verify(heading).turnRight();
    }
}

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LeftCommandShould {

    @Test
    public void turn_rover_left() {
        HeadingNorth heading = mock(HeadingNorth.class);
        Rover rover = new Rover(new Point(1, 1), heading);
        LeftCommand command = new LeftCommand();

        command.execute(rover);

        verify(heading).turnLeft();
    }
}

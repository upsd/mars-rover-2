package upsd.commands;

import org.junit.jupiter.api.Test;
import upsd.domain.Grid;
import upsd.domain.Point;
import upsd.domain.Rover;
import upsd.headings.HeadingNorth;

import static org.mockito.Mockito.*;

public class MoveCommandShould {

    @Test
    void move_rover() {
        HeadingNorth heading = mock(HeadingNorth.class);
        Grid grid = mock(Grid.class);
        Rover rover = new Rover(new Point(1, 2), heading, grid);
        MoveCommand command = new MoveCommand();

        when(heading.move(new Point(1, 2))).thenReturn(new Point(1, 4));


        command.execute(rover);


        verify(heading).move(new Point(1, 2));
        verify(grid).sanitisePoint(new Point(1, 4));
    }
}

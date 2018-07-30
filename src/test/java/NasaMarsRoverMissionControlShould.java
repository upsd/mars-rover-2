import org.junit.Test;

import static java.util.Arrays.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NasaMarsRoverMissionControlShould {

    @Test
    public void get_final_coordinates_and_headings() {
        InputParser parser = mock(InputParser.class);
        String input = "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM";

        Grid grid = new Grid(new Point(5, 5));
        when(parser.parseGridFrom(input)).thenReturn(grid);
        when(parser.parseRoversFrom(input)).thenReturn(asList(
                new Rover(new Point(1, 2), Heading.NORTH),
                new Rover(new Point(3, 3), Heading.EAST))
        );
        when(parser.parseCommandsFrom(input, grid)).thenReturn(asList(
                asList(
                        new LeftCommand(),
                        new MoveCommand(grid),
                        new LeftCommand(),
                        new MoveCommand(grid),
                        new LeftCommand(),
                        new MoveCommand(grid),
                        new LeftCommand(),
                        new MoveCommand(grid),
                        new MoveCommand(grid)
                ),
                asList(
                        new MoveCommand(grid),
                        new MoveCommand(grid),
                        new RightCommand(),
                        new MoveCommand(grid),
                        new MoveCommand(grid),
                        new RightCommand(),
                        new MoveCommand(grid),
                        new RightCommand(),
                        new RightCommand(),
                        new MoveCommand(grid)
                )
        ));

        NasaMarsRoverMissionControl missionControl = new NasaMarsRoverMissionControl(
                input,
                parser
        );

        String output = missionControl.getFinalCoordinatesAndHeadings();

        assertThat(output, is("1 3 N\n5 1 E"));
    }
}

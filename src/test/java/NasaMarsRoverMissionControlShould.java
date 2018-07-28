import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NasaMarsRoverMissionControlShould {

    @Test
    public void get_final_coordinates_and_headings() {
        InputParser parser = mock(InputParser.class);
        String input = "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM";
        NasaMarsRoverMissionControl missionControl = new NasaMarsRoverMissionControl(
                input,
                parser
        );

        when(parser.parseGridFrom(input)).thenReturn(new Grid(new Point(5, 5)));
        when(parser.parseRoversFrom(input)).thenReturn(new Rovers(new Rover(new Point(1, 2), Heading.NORTH)));
        when(parser.parseCommandsFrom(input)).thenReturn(Arrays.asList(
                new CommandSet(
                        new LeftCommand(),
                        new MoveCommand(),
                        new LeftCommand(),
                        new MoveCommand(),
                        new LeftCommand(),
                        new MoveCommand(),
                        new LeftCommand(),
                        new MoveCommand(),
                        new MoveCommand()
                ),
                new CommandSet(
                        new MoveCommand(),
                        new MoveCommand(),
                        new RightCommand(),
                        new MoveCommand(),
                        new MoveCommand(),
                        new RightCommand(),
                        new MoveCommand(),
                        new RightCommand(),
                        new RightCommand(),
                        new MoveCommand()
                )
        ));

        String output = missionControl.getFinalCoordinatesAndHeadings();

        assertThat(output, is("1 3 N\n5 1 E"));
    }
}
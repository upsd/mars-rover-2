package upsd.domain;

import org.junit.Test;
import upsd.commands.Command;
import upsd.commands.CommandExecutor;
import upsd.commands.LeftCommand;
import upsd.commands.MoveCommand;
import upsd.headings.HeadingNorth;
import upsd.input_and_output.InputParser;
import upsd.input_and_output.OutputFormatter;
import upsd.input_and_output.ParserResult;

import java.util.LinkedHashMap;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class NasaMarsRoverMissionControlShould {

    @Test
    public void get_final_coordinates_and_headings() {
        InputParser parser = mock(InputParser.class);
        String input = "Some input that does not matter for this test.";
        OutputFormatter formatter = mock(OutputFormatter.class);
        CommandExecutor commandExecutor = mock(CommandExecutor.class);

        LinkedHashMap<Rover, List<Command>> roversAndCommands = new LinkedHashMap<>();
        roversAndCommands.put(
                new Rover(new Point(4, 3), new HeadingNorth()),
                asList(
                        new LeftCommand(),
                        new MoveCommand(new Grid(new Point(10, 10)))
                )
        );
        ParserResult result = new ParserResult(roversAndCommands);
        List<Rover> rovers = asList(
                new Rover(
                        new Point(4, 3),
                        new HeadingNorth())
        );


        when(parser.parse(input)).thenReturn(result);
        when(commandExecutor.executeAll(result)).thenReturn(rovers);
        when(formatter.format(rovers)).thenReturn("Is there life on Mars?");


        NasaMarsRoverMissionControl missionControl = new NasaMarsRoverMissionControl(
                input,
                parser,
                formatter,
                commandExecutor
        );




        String finalCoordinatesAndHeadings = missionControl.getFinalCoordinatesAndHeadings();




        verify(parser).parse(any());
        verify(commandExecutor).executeAll(any());
        verify(formatter).format(any());

        assertThat(finalCoordinatesAndHeadings, is("Is there life on Mars?"));
    }
}

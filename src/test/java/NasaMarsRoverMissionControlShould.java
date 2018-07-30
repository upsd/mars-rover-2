import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NasaMarsRoverMissionControlShould {

    @Test
    public void get_final_coordinates_and_headings() {
        InputParser parser = mock(InputParser.class);
        String input = "Some input that does not matter for this test.";
        OutputFormatter formatter = mock(OutputFormatter.class);
        CommandExecutor commandExecutor = mock(CommandExecutor.class);
        NasaMarsRoverMissionControl missionControl = new NasaMarsRoverMissionControl(
                input,
                parser,
                formatter,
                commandExecutor
        );



        missionControl.getFinalCoordinatesAndHeadings();


        verify(parser).parseGridFrom(any());
        verify(parser).parseRoversFrom(any());
        verify(parser).parseCommandsFrom(any(), any());
        verify(formatter).format(any());
        verify(commandExecutor).executeAll(any(), any());
    }
}

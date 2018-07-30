import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MarsRoverAcceptanceTest {

    @Test
    public void return_final_coordinates_and_headings_for_rovers() {
        NasaMarsRoverMissionControl control = new NasaMarsRoverMissionControl(
                "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM",
                new InputParser(),
                new OutputFormatter(), new CommandExecutor());

        String output = control.getFinalCoordinatesAndHeadings();

        assertThat(output, is("1 3 N\n5 1 E"));
    }
}

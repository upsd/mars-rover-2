package upsd.commands;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import upsd.domain.Grid;
import upsd.domain.Point;
import upsd.domain.Rover;
import upsd.headings.HeadingEast;
import upsd.headings.HeadingNorth;
import upsd.headings.HeadingSouth;
import upsd.headings.HeadingWest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MoveCommandShould {

    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "2, 3",
            "3, 4",
            "4, 5"
    })
    void move_rover_within_bounds_of_grid_when_facing_north(int startingY, int expectedY) {
        Rover rover = new Rover(new Point(1, startingY), new HeadingNorth());
        MoveCommand command = new MoveCommand(new Grid(new Point(5, 5)));

        Rover newRover = command.execute(rover);

        assertThat(newRover.y(), is(expectedY));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "2, 3",
            "3, 4",
            "4, 5"
    })
    void move_rover_within_bounds_of_grid_when_facing_east(int startingX, int expectedX) {
        Rover rover = new Rover(new Point(startingX, 2), new HeadingEast());
        MoveCommand command = new MoveCommand(new Grid(new Point(5, 5)));

        Rover newRover = command.execute(rover);

        assertThat(newRover.x(), is(expectedX));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 1",
            "3, 2",
            "4, 3",
            "5, 4"
    })
    void move_rover_within_bounds_of_grid_when_facing_south(int startingY, int expectedY) {
        Rover rover = new Rover(new Point(2, startingY), new HeadingSouth());
        MoveCommand command = new MoveCommand(new Grid(new Point(5, 5)));

        Rover newRover = command.execute(rover);

        assertThat(newRover.y(), is(expectedY));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 1",
            "3, 2",
            "4, 3",
            "5, 4"
    })
    void move_rover_within_bounds_of_grid_when_facing_west(int startingX, int expectedX) {
        Rover rover = new Rover(new Point(startingX, 2), new HeadingWest());
        MoveCommand command = new MoveCommand(new Grid(new Point(5, 5)));

        Rover newRover = command.execute(rover);

        assertThat(newRover.x(), is(expectedX));
    }

    @Test
    void move_rover_to_min_Y_of_grid_when_moving_northwards() {
        Rover rover = new Rover(new Point(2, 2), new HeadingNorth());
        MoveCommand command = new MoveCommand(new Grid(new Point(2, 2)));

        Rover newRover = command.execute(rover);

        assertThat(newRover.y(), is(1));
    }

    @Test
    void move_rover_to_min_x_of_grid_when_moving_eastwards() {
        Rover rover = new Rover(new Point(2, 2), new HeadingEast());
        MoveCommand command = new MoveCommand(new Grid(new Point(2, 2)));

        Rover newRover = command.execute(rover);

        assertThat(newRover.x(), is(1));
    }

    @Test
    void move_rover_to_max_y_of_grid_when_moving_southwards() {
        Rover rover = new Rover(new Point(2, 1), new HeadingSouth());
        MoveCommand command = new MoveCommand(new Grid(new Point(2, 2)));

        Rover newRover = command.execute(rover);

        assertThat(newRover.y(), is(2));
    }

    @Test
    void move_rover_to_max_x_of_grid_when_moving_westwards() {
        Rover rover = new Rover(new Point(1, 2), new HeadingWest());
        MoveCommand command = new MoveCommand(new Grid(new Point(2, 2)));

        Rover newRover = command.execute(rover);

        assertThat(newRover.x(), is(2));
    }
}

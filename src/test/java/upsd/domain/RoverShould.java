package upsd.domain;

import org.junit.jupiter.api.Test;
import upsd.headings.Heading;
import upsd.headings.HeadingSouth;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class RoverShould {

    @Test
    void report_its_x_position() {
        Rover rover = new Rover(new Point(2, 2), null, null);
        assertThat(rover.x(), is(2));
    }

    @Test
    public void report_its_y_position() {
        Rover rover = new Rover(new Point(2, 2), null, null);
        assertThat(rover.y(), is(2));
    }
    
    @Test
    public void turn_left() {
        Heading heading = mock(Heading.class);
        Rover rover = new Rover(new Point(1, 1), heading, null);

        when(heading.turnLeft()).thenReturn(new HeadingSouth());


        rover.turnLeft();


        verify(heading).turnLeft();
    }

    @Test
    void turn_right() {
        Heading heading = mock(Heading.class);
        Rover rover = new Rover(new Point(1, 1), heading, null);

        when(heading.turnRight()).thenReturn(new HeadingSouth());


        rover.turnRight();


        verify(heading).turnRight();
    }

    @Test
    void move() {
        Heading heading = mock(Heading.class);
        Rover rover = new Rover(new Point(1, 1), heading, new Grid(new Point(5, 5)));

        when(heading.move(new Point(1, 1))).thenReturn(new Point(5, 5));


        rover.move();


        verify(heading).move(new Point(1, 1));
    }

    @Test
    void get_abbreviation_of_current_heading() {
        Heading heading = mock(Heading.class);
        Rover rover = new Rover(new Point(2, 2), heading, new Grid(new Point(1, 1)));

        when(heading.abbreviation()).thenReturn("SOLID");


        String abbreviation = rover.headingAbbreviation();


        assertThat(abbreviation, is("SOLID"));
    }
}

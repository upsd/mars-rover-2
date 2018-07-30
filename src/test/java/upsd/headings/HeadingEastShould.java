package upsd.headings;

import org.junit.jupiter.api.Test;
import upsd.domain.Point;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class HeadingEastShould {

    private HeadingEast heading = new HeadingEast();

    @Test
    void move_rover() {
        Point originalPoint = new Point(2, 2);

        Point newPoint = heading.move(originalPoint);

        assertThat(newPoint.x(), is(originalPoint.x() + 1));
    }

    @Test
    void turn_left() {
        Heading newHeading = this.heading.turnLeft();

        assertTrue(newHeading instanceof HeadingNorth);
    }

    @Test
    void turn_right() {
        Heading newHeading = this.heading.turnRight();

        assertTrue(newHeading instanceof HeadingSouth);
    }

    @Test
    void return_abbreviation() {
        String abbreviation = heading.abbreviation();

        assertThat(abbreviation, is("E"));
    }
}

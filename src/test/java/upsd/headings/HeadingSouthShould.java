package upsd.headings;

import org.junit.jupiter.api.Test;
import upsd.domain.Point;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class HeadingSouthShould {

    private HeadingSouth heading = new HeadingSouth();

    @Test
    void move_rover() {
        Point originalPoint = new Point(2, 2);

        Point newPoint = heading.move(originalPoint);

        assertThat(newPoint.y(), is(originalPoint.y() - 1));
    }

    @Test
    void turn_left() {
        Heading newHeading = this.heading.turnLeft();

        assertTrue(newHeading instanceof HeadingEast);
    }

    @Test
    void turn_right() {
        Heading newHeading = this.heading.turnRight();

        assertTrue(newHeading instanceof HeadingWest);
    }

    @Test
    void return_abbreviation() {
        String abbreviation = heading.abbreviation();

        assertThat(abbreviation, is("S"));
    }
}

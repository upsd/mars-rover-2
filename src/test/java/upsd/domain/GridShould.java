package upsd.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GridShould {

    private Grid grid = new Grid(new Point(2, 2));

    @Test
    void validate_X_value_that_is_too_small() {
        Point newCoordinate = grid.sanitisePoint(new Point(0, 2));

        assertThat(newCoordinate.x(), is(2));
    }

    @Test
    void validate_X_coordinate_that_is_too_large() {
        Point newCoordinate = grid.sanitisePoint(new Point(3, 2));

        assertThat(newCoordinate.x(), is(1));
    }

    @Test
    public void validate_X_coordinate_that_is_valid() {
        Point newCoordinate = grid.sanitisePoint(new Point(2, 2));

        assertThat(newCoordinate.x(), is(2));
    }

    @Test
    void validate_Y_value_that_is_too_small() {
        Point newCoordinate = grid.sanitisePoint(new Point(2, -1));

        assertThat(newCoordinate.y(), is(2));
    }

    @Test
    void validate_Y_coordinate_that_is_too_large() {
        Point newCoordinate = grid.sanitisePoint(new Point(2, 3));

        assertThat(newCoordinate.y(), is(1));
    }

    @Test
    public void validate_Y_coordinate_that_is_valid() {
        Point newCoordinate = grid.sanitisePoint(new Point(2, 2));

        assertThat(newCoordinate.y(), is(2));
    }
}

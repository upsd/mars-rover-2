import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GridShould {

    private Grid grid = new Grid(new Point(2, 2));

    @Test
    void validate_X_value_that_is_too_small() {
        int newCoordinate = grid.validateXCoordinate(-1);

        assertThat(newCoordinate, is(2));
    }

    @Test
    void validate_X_coordinate_that_is_too_large() {
        int newCoordinate = grid.validateXCoordinate(3);

        assertThat(newCoordinate, is(1));
    }

    @Test
    public void validate_X_coordinate_that_is_valid() {
        int newCoordinate = grid.validateXCoordinate(2);

        assertThat(newCoordinate, is(2));
    }

    @Test
    void validate_Y_value_that_is_too_small() {
        int newCoordinate = grid.validateYCoordinate(-1);

        assertThat(newCoordinate, is(2));
    }

    @Test
    void validate_Y_coordinate_that_is_too_large() {
        int newCoordinate = grid.validateYCoordinate(3);

        assertThat(newCoordinate, is(1));
    }

    @Test
    public void validate_Y_coordinate_that_is_valid() {
        int newCoordinate = grid.validateYCoordinate(2);

        assertThat(newCoordinate, is(2));
    }
}

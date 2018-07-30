package upsd.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GridShould {

    private Grid grid = new Grid(new Point(2, 2));

    @ParameterizedTest
    @CsvSource({
            "0, 2",
            "3, 1",
            "2, 2"
    })
    void validate_X(int x, int expectedX) {
        Point newCoordinate = grid.sanitisePoint(new Point(x, 2));

        assertThat(newCoordinate.x(), is(expectedX));
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 2",
            "3, 1",
            "2, 2"
    })
    void validate_Y(int y, int expectedY) {
        Point newCoordinate = grid.sanitisePoint(new Point(2, y));

        assertThat(newCoordinate.y(), is(expectedY));
    }
}

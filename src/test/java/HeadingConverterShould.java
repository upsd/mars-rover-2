import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class HeadingConverterShould {

    private HeadingConverter converter = new HeadingConverter();

    @Test
    void convert_to_north() {
        Heading north = converter.toHeading("N");

        assertTrue(north instanceof HeadingNorth);
    }

    @Test
    void convert_to_east() {
        Heading east = converter.toHeading("E");

        assertTrue(east instanceof HeadingEast);
    }

    @Test
    void convert_to_south() {
        Heading south = converter.toHeading("S");

        assertTrue(south instanceof HeadingSouth);
    }

    @Test
    void convert_to_west() {
        Heading west = converter.toHeading("W");

        assertTrue(west instanceof HeadingWest);
    }
}

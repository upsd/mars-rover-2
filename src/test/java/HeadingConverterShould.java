import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HeadingConverterShould {

    @ParameterizedTest
    @MethodSource("headingAndAbbrevationProvider")
    void convert_to_abbreviation(Heading headingToConvert, String expectedAbbreviation) {
        HeadingConverter converter = new HeadingConverter();

        String abbreviation = converter.toAbbreviation(headingToConvert);

        assertThat(abbreviation, is(expectedAbbreviation));
    }

    static Stream<Arguments> headingAndAbbrevationProvider() {
        return Stream.of(
                Arguments.of(Heading.NORTH, "N"),
                Arguments.of(Heading.EAST, "E"),
                Arguments.of(Heading.SOUTH, "S"),
                Arguments.of(Heading.WEST, "W")
        );
    }
}

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HeadingConverterShould {

    @ParameterizedTest
    @MethodSource("headingAndAbbreviationProvider")
    void convert_to_abbreviation(Heading headingToConvert, String expectedAbbreviation) {
        HeadingConverter converter = new HeadingConverter();

        String abbreviation = converter.toAbbreviation(headingToConvert);

        assertThat(abbreviation, is(expectedAbbreviation));
    }

    static Stream<Arguments> headingAndAbbreviationProvider() {
        return Stream.of(
                Arguments.of(Heading.NORTH, "N"),
                Arguments.of(Heading.EAST, "E"),
                Arguments.of(Heading.SOUTH, "S"),
                Arguments.of(Heading.WEST, "W")
        );
    }

    @ParameterizedTest
    @MethodSource("abbreviationAndHeadingProvider")
    void convert_to_heading(String abbreviationToConvert, Heading expectedHeading) {
        HeadingConverter converter = new HeadingConverter();

        Heading heading = converter.toHeading(abbreviationToConvert);

        assertThat(heading, is(expectedHeading));
    }

    static Stream<Arguments> abbreviationAndHeadingProvider() {
        return Stream.of(
                Arguments.of("N", Heading.NORTH),
                Arguments.of("E", Heading.EAST),
                Arguments.of("S", Heading.SOUTH),
                Arguments.of("W", Heading.WEST)
        );
    }
}

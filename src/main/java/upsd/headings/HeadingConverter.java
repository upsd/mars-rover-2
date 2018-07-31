package upsd.headings;

import java.util.HashMap;
import java.util.Map;

public class HeadingConverter {

    private final Map<Heading, String> headingAndAbbreviations = new HashMap<>();

    public HeadingConverter() {
        this.headingAndAbbreviations.put(new HeadingNorth(), "N");
        this.headingAndAbbreviations.put(new HeadingEast(), "E");
        this.headingAndAbbreviations.put(new HeadingSouth(), "S");
        this.headingAndAbbreviations.put(new HeadingWest(), "W");
    }

    public Heading toHeading(String abbreviation) {
        return this.headingAndAbbreviations.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(abbreviation))
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
    }
}

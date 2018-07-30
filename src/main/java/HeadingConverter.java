import java.util.HashMap;
import java.util.Map;

public class HeadingConverter {

    private final Map<Heading, String> headingAndAbbreviations = new HashMap<>();

    public HeadingConverter() {
        this.headingAndAbbreviations.put(Heading.NORTH, "N");
        this.headingAndAbbreviations.put(Heading.EAST, "E");
        this.headingAndAbbreviations.put(Heading.SOUTH, "S");
        this.headingAndAbbreviations.put(Heading.WEST, "W");
    }

    public String toAbbreviation(Heading heading) {
        return this.headingAndAbbreviations.get(heading);
    }

    public Heading toHeading(String abbreviation) {
        return this.headingAndAbbreviations.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(abbreviation))
                .map(Map.Entry::getKey).findFirst()
                .get();
    }
}

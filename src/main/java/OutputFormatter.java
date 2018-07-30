import java.util.List;
import java.util.stream.Collectors;

public class OutputFormatter {

    private final HeadingConverter converter;

    public OutputFormatter() {
        this.converter = new HeadingConverter();
    }

    public String format(List<Rover> rovers) {
        return rovers
                .stream()
                .map(r -> String.format("%d %d %s", r.x(), r.y(), converter.toAbbreviation(r.heading())))
                .collect(Collectors.joining("\n"));
    }
}

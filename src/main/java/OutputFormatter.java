import java.util.List;
import java.util.stream.Collectors;

public class OutputFormatter {

    public String format(List<Rover> rovers) {
        return rovers
                .stream()
                .map(r -> String.format("%d %d %s", r.x(), r.y(), r.heading().abbreviation()))
                .collect(Collectors.joining("\n"));
    }
}

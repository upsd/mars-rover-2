import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {

    public List<Rover> executeAll(List<List<Command>> commands, List<Rover> rovers) {
        List<Rover> roversPostCommands = new ArrayList<>();

        commands.stream().forEach(set -> {
            int index = commands.indexOf(set);
            final Rover[] rover = {rovers.get(index)};

            set.stream().forEach(command -> {
                rover[0] = command.execute(rover[0]);
            });
            roversPostCommands.add(rover[0]);
        });
        return roversPostCommands;
    }
}

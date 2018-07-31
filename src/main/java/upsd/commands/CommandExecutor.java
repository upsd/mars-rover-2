package upsd.commands;

import upsd.domain.Rover;
import upsd.input_and_output.ParserResult;

import java.util.List;
import java.util.stream.Collectors;

public class CommandExecutor {

    public List<Rover> executeAll(ParserResult translationResult) {
        return translationResult.roverAndCommands()
                .entrySet()
                .stream()
                .map(entry -> {
                    final Rover[] rover = {entry.getKey()};

                    List<Command> commands = entry.getValue();
                    commands.stream().forEach(command -> rover[0] = command.execute(rover[0]));

                    return rover[0];
                })
                .collect(Collectors.toList());
    }
}

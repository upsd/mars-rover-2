package upsd.commands;

import upsd.domain.Rover;
import upsd.input_and_output.ParserResult;

import java.util.List;

public class CommandExecutor {

    public void executeAll(ParserResult translationResult) {
        translationResult.roverAndCommands()
                .entrySet()
                .stream()
                .forEach(entry -> {
                    Rover rover = entry.getKey();

                    List<Command> commands = entry.getValue();
                    commands.stream().forEach(command -> command.execute(rover));
                });
    }
}

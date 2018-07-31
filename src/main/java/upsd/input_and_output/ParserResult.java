package upsd.input_and_output;

import upsd.commands.Command;
import upsd.domain.Rover;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ParserResult {

    private Map<Rover, List<Command>> roverAndCommands;

    public ParserResult(LinkedHashMap<Rover, List<Command>> roverAndCommands) {
        this.roverAndCommands = roverAndCommands;
    }

    public Map<Rover, List<Command>> roverAndCommands() {
        return this.roverAndCommands;
    }
}

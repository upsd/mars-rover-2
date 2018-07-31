package upsd.domain;

import upsd.commands.CommandExecutor;
import upsd.input_and_output.InputParser;
import upsd.input_and_output.OutputFormatter;
import upsd.input_and_output.ParserResult;

import java.util.List;

public class NasaMarsRoverMissionControl {

    private final ParserResult translationResult;
    private OutputFormatter formatter;
    private CommandExecutor commandExecutor;

    public NasaMarsRoverMissionControl(String input, InputParser parser, OutputFormatter outputFormatter, CommandExecutor commandExecutor) {
        this.formatter = outputFormatter;
        this.commandExecutor = commandExecutor;
        this.translationResult = parser.parse(input);
    }

    public String getFinalCoordinatesAndHeadings() {
        return formatter.format(executeCommandsAndGetNewRovers());
    }

    private List<Rover> executeCommandsAndGetNewRovers() {
        return commandExecutor.executeAll(translationResult);
    }
}

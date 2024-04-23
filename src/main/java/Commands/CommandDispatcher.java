package Commands;

import java.util.Arrays;
import java.util.List;

public class CommandDispatcher {
    private final List<Commands> commands;

    public CommandDispatcher(List<Commands> commands) {
        this.commands = commands;
    }

    public void executeCommand(String string) {
        Commands command = getCommand(string.split(" ")[0]);
        String[] commandData = Arrays.copyOfRange(string.split(" "), 1, string.split(" ").length);
        try {
            command.execute(commandData);
        } catch (IllegalArgumentException e) {
            System.out.printf("ERROR: %s%n", e.getMessage());
        }
    }

    private Commands getCommand(String commandName) {
        for (Commands command : commands) {
            if (command.name().equals(commandName)) {
                return command;
            }
        }

        throw new IllegalArgumentException();
    }
}

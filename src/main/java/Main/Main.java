package Main;

import Commands.*;
import Repository.RepositoryImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final RepositoryImpl repository = new RepositoryImpl();
    private static final List<Commands> commands = List.of(
            new CreateCommand(repository),
            new ReadCommand(repository),
            new UpdateCommand(repository),
            new DeleteCommand(repository),
            new ExitCommand(repository)
    );
    private static final CommandDispatcher commandDispatcher = new CommandDispatcher(commands);

    public static void main(String[] args) {
        System.out.println("Program has been started successfully!");

        String command = getCommand();

        while (!command.equals("exit")) {
            try {
                commandDispatcher.executeCommand(command);
            } catch (IllegalArgumentException e) {
                System.out.println("No such command.");
            }
            command = getCommand();
        }

        System.out.println("Program has been finished successfully!");
    }

    private static String getCommand() {
        System.out.print("Enter your command: ");
        return new Scanner(System.in).nextLine().strip();
    }
}

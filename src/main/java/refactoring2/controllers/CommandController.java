package refactoring2.controllers;

import refactoring2.entities.commands.*;
import refactoring2.services.ProductService;

import java.util.Arrays;
import java.util.List;

public class CommandController {
    private ProductService productService;
    private List<Command> availableCommands;

    public CommandController(ProductService productService) {
        this.productService = productService;

        availableCommands = List.of(
                new ReadCommand(productService),
                new CreateCommand(productService),
                new UpdateCommand(productService),
                new DeleteCommand(productService),
                new ExitCommand(productService)
        );
    }

    public void executeCommand(String stringCommandData) {
        String commandName = stringCommandData.split(" ")[0];

        for (Command availableCommand : availableCommands) {
            if (commandName.equals(availableCommand.getName())) {
                availableCommand.execute(stringCommandData);
                return;
            }
        }
        throw new IllegalArgumentException("There is no such command. Try again with \"create\", \"read\", \"update\", \"delete\" or \"exit\"!");
    }
}

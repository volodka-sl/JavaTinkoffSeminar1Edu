package refactoring2;

import refactoring2.controllers.CommandController;
import refactoring2.repositories.ProductRepository;
import refactoring2.repositories.ProductRepositoryImpl;
import refactoring2.services.ProductService;
import refactoring2.services.ProductServiceImpl;

import java.util.Scanner;

public class Main {
    private static ProductRepository productRepository = new ProductRepositoryImpl();
    private static ProductService productService = new ProductServiceImpl(productRepository);
    private static CommandController commandController = new CommandController(productService);

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Program has been started successfully!");

        String stringCommandData = requestCommand();
        while (true) {
            try {
                commandController.executeCommand(stringCommandData);
            } catch (Exception e) {
                System.out.printf("Error: %s%n", e.getMessage());
            }
            stringCommandData = requestCommand();
        }
    }

    private static String requestCommand() {
        System.out.print("Enter your command: ");
        return scanner.nextLine();
    }
}

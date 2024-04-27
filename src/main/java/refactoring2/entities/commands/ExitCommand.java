package refactoring2.entities.commands;

import refactoring2.entities.product.Product;
import refactoring2.services.ProductService;

public class ExitCommand extends Command {
    public ExitCommand(ProductService productService) {
        super(productService);
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public void execute(String stringCommandData) {
        System.out.println("Goodbye!");
        System.exit(0);
    }
}

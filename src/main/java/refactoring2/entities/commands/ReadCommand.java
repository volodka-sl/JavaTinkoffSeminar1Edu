package refactoring2.entities.commands;

import refactoring2.services.ProductService;

public class ReadCommand extends Command {
    public ReadCommand(ProductService productService) {
        super(productService);
    }

    @Override
    public String getName() {
        return "read";
    }

    @Override
    public void execute(String stringCommandData) {
        productService.read(stringCommandData);
    }
}

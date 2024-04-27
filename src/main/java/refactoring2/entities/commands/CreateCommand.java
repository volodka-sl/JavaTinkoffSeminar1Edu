package refactoring2.entities.commands;

import refactoring2.entities.product.Product;
import refactoring2.services.ProductService;

public class CreateCommand extends Command {
    public CreateCommand(ProductService productService) {
        super(productService);
    }

    @Override
    public String getName() {
        return "create";
    }

    @Override
    public void execute(String stringCommandData) {
        Product product = productService.create(stringCommandData);
        System.out.printf("Product with article #%s was successfully created!%n", product.getArticle());
    }
}

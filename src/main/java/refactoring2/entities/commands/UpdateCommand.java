package refactoring2.entities.commands;

import refactoring2.entities.product.Product;
import refactoring2.services.ProductService;

public class UpdateCommand extends Command {
    public UpdateCommand(ProductService productService) {
        super(productService);
    }

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public void execute(String stringCommandData) {
        Product product = productService.update(stringCommandData);
        System.out.printf("Product with article #%s was successfully updated!%n", product.getArticle());
    }
}

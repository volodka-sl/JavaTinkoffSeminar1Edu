package refactoring2.entities.commands;

import refactoring2.entities.product.Product;
import refactoring2.services.ProductService;

public class DeleteCommand extends Command {
    public DeleteCommand(ProductService productService) {
        super(productService);
    }

    @Override
    public String getName() {
        return "delete";
    }

    @Override
    public void execute(String stringCommandData) {
        Product product = productService.delete(stringCommandData);
        System.out.printf("Product with article #%s was successfully deleted!%n", product.getArticle());
    }
}

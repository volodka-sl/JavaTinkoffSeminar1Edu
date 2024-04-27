package refactoring2.entities.commands;

import refactoring2.services.ProductService;

public abstract class Command {
    protected ProductService productService;

    protected Command(ProductService productService) {
        this.productService = productService;
    }

    public abstract String getName();
    public abstract void execute(String stringCommandData);
}

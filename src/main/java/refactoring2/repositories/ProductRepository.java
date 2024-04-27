package refactoring2.repositories;

import refactoring2.entities.product.Product;

public interface ProductRepository {
    Product create(Product product);
    void read();
    Product update(Product product);
    Product delete(String article);
}

package refactoring2.services;

import refactoring2.entities.product.Product;

public interface ProductService {
    Product create(String stringCommandData);
    void read(String stringCommandData);
    Product update(String stringCommandData);
    Product delete(String stringCommandData);
}

package Repository;

import Product.Product;

public interface Repository {
    void read();
    boolean create(Product product);
    boolean update(Product product);
    boolean delete(String productArticle);
}

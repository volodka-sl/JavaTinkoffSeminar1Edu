package Repository;

import Product.Product;

import java.util.HashMap;
import java.util.Map;

public class RepositoryImpl implements Repository {
    public static final Map<String, Product> products = new HashMap<>();

    @Override
    public void read() {
        if (products.isEmpty()) {
            System.out.println("No products to read.");
            return;
        }
        StringBuilder resultString = new StringBuilder();

        resultString.append(String.format("+%-10s+%-30s+%-10s+%-10s+%n", "-".repeat(10), "-".repeat(30), "-".repeat(10), "-".repeat(10)));
        resultString.append(String.format("|%-10s|%-30s|%-10s|%-10s|%n", " " + "Article", " " + "Name", " " + "Price", " " + "Amount"));
        resultString.append(String.format("+%-10s+%-30s+%-10s+%-10s+%n", "-".repeat(10), "-".repeat(30), "-".repeat(10), "-".repeat(10)));
        for (Product product : products.values()) {
            resultString.append(String.format("|%-10s", " " + product.getArticle()));
            resultString.append(String.format("|%-30s", " " + product.getName()));
            resultString.append(String.format("|%-10s", " " + product.getPrice()));
            resultString.append(String.format("|%-10s|", " " + product.getAmount()));

            resultString.append("\n");
        }
        resultString.append(String.format("+%-10s+%-30s+%-10s+%-10s+%n", "-".repeat(10), "-".repeat(30), "-".repeat(10), "-".repeat(10)));

        System.out.println(resultString);
    }

    @Override
    public boolean create(Product product) {
        if (products.containsKey(product.getArticle())) {
            throw new IllegalArgumentException("Such article is already in the table.");
        }

        products.put(product.getArticle(), product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        if (products.containsKey(product.getArticle())) {
            if (products.put(product.getArticle(), product) != null) {
                return true;
            }
        }
        throw new IllegalArgumentException("No such product to update.");
    }

    @Override
    public boolean delete(String productArticle) {
        if (products.remove(productArticle) != null) {
            return true;
        }
        throw new IllegalArgumentException("No such product to delete.");
    }
}

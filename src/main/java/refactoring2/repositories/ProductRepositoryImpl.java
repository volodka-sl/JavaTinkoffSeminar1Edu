package refactoring2.repositories;

import refactoring2.entities.product.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {
    private Map<String, Product> products = new HashMap<>();

    @Override
    public Product create(Product product) {
        if (products.containsKey(product.getArticle())) {
            throw new IllegalArgumentException("Such product has been already created. Try to update it!");
        }
        products.put(product.getArticle(), product);
        return product;
    }

    @Override
    public void read() {
        if (products.isEmpty()) {
            System.out.println("Command \"read\" has been executed successfully, but there is no products to show. Try to create firstly!");
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
    public Product update(Product product) {
        if (!products.containsKey(product.getArticle())) {
            throw new IllegalArgumentException("There is no such product. Try to create firstly!");
        }
        products.put(product.getArticle(), product);
        return product;
    }

    @Override
    public Product delete(String article) {
        if (!products.containsKey(article)) {
            throw new IllegalArgumentException("There is no such product. Try to create firstly!");
        }
        return products.remove(article);
    }
}

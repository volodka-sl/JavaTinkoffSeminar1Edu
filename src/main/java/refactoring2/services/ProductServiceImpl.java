package refactoring2.services;

import refactoring2.entities.product.Product;
import refactoring2.repositories.ProductRepository;

import java.util.Arrays;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(String stringCommandData) {
        String[] commandData = getCommandData(stringCommandData);

        if (commandData.length < 4) {
            throw new IllegalArgumentException("\"Create\" command data must contain article, name, price and amount. Try again with existent params!");
        }

        String article = validateArticle(commandData[0]);
        String name = String.join(" ", Arrays.copyOfRange(commandData, 1, commandData.length - 2));
        double price = validatePrice(commandData[commandData.length - 2]);
        int amount = validateAmount(commandData[commandData.length - 1]);

        return productRepository.create(new Product(article, name, price, amount));
    }

    @Override
    public void read(String stringCommandData) {
        String[] commandData = getCommandData(stringCommandData);

        if (commandData.length != 0) {
            throw new IllegalArgumentException("\"Read\" command data must not contain any params. Try again!");
        }

        productRepository.read();
    }

    @Override
    public Product update(String stringCommandData) {
        String[] commandData = getCommandData(stringCommandData);

        if (commandData.length < 4) {
            throw new IllegalArgumentException("\"Update\" command data must contain article, name, price and amount. Try again with existent params!");
        }

        String article = validateArticle(commandData[0]);
        String name = String.join(" ", Arrays.copyOfRange(commandData, 1, commandData.length - 2));
        double price = validatePrice(commandData[commandData.length - 2]);
        int amount = validateAmount(commandData[commandData.length - 1]);

        return productRepository.update(new Product(article, name, price, amount));
    }

    @Override
    public Product delete(String stringCommandData) {
        String[] commandData = getCommandData(stringCommandData);

        if (commandData.length != 1) {
            throw new IllegalArgumentException("\"Delete\" command data must contain article only. Try again with existent params!");
        }

        String article = validateArticle(commandData[0]);

        return productRepository.delete(article);
    }

    private String[] getCommandData(String stringCommandData) {
        if (stringCommandData.split(" ").length == 1) {
            return new String[0];
        }
        return Arrays.copyOfRange(stringCommandData.split(" "), 1, stringCommandData.split(" ").length);
    }

    private String validateArticle(String article) {
        if (!article.matches("^[A-Z0-9]+$")) {
            throw new IllegalArgumentException("Article must contains numbers and uppercase letters only. Try again!");
        }
        return article;
    }

    private double validatePrice(String stringPrice) {
        try {
            if (Double.parseDouble(stringPrice) > 0) {
                return Double.parseDouble(stringPrice);
            }
            throw new IllegalArgumentException("Price must be more than zero. Try again!");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Price must be double. Try again!");
        }
    }

    private int validateAmount(String stringAmount) {
        try {
            if (Integer.parseInt(stringAmount) > 0) {
                return Integer.parseInt(stringAmount);
            }
            throw new IllegalArgumentException("Amount must be more than zero. Try again!");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Amount must be integer. Try again!");
        }
    }
}

package Product;

import java.util.Objects;

public class Product {
    private String article;
    private String name;
    private double price;
    private int amount;

    public Product(String article, String name, double price, int amount) {
        this.article = article;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getArticle() {
        return article;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && amount == product.amount && Objects.equals(article, product.article) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article, name, price, amount);
    }

    @Override
    public String toString() {
        return "Product{" +
                "article='" + article + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}

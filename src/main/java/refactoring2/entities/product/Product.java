package refactoring2.entities.product;

public class Product {
    String article;
    String name;
    double price;
    int amount;

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
}

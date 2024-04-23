package Commands;

import Product.Product;
import Repository.RepositoryImpl;

import java.util.Arrays;

public class CreateCommand extends Commands {
    public CreateCommand(RepositoryImpl repository) {
        super(repository);
    }

    @Override
    public String name() {
        return "create";
    }

    @Override
    public void execute(String[] commandData) {
        if (commandData.length < 4) {
            throw new IllegalArgumentException("Cannot create product. Specify all arguments.");
        }
        try {
            String article = commandData[0];
            String name = String.join(" ", Arrays.copyOfRange(commandData, 1, commandData.length - 2));
            double price = Double.parseDouble(commandData[commandData.length - 2]);
            int amount = Integer.parseInt(commandData[commandData.length - 1]);

            if (!article.matches("^[A-Z0-9]+$")) {
                throw new IllegalArgumentException("Article must contain Latin alphabet uppercase letters and numbers only. Try again.");
            }

            if (price < 0 || amount < 0) {
                throw new IllegalArgumentException("Cannot create product. Specify numbers rightly.");
            }

            repository.create(new Product(article, name, price, amount));
            System.out.printf("Successfully added product \"%s\" with article #%s.%n", name, article);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Cannot create product. Specify numbers rightly.");
        }
    }
}

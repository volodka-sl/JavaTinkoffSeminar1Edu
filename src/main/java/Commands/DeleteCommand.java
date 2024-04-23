package Commands;

import Repository.RepositoryImpl;

public class DeleteCommand extends Commands {
    public DeleteCommand(RepositoryImpl repository) {
        super(repository);
    }

    @Override
    public String name() {
        return "delete";
    }

    @Override
    public void execute(String[] commandData) {
        if (commandData.length != 1) {
            throw new IllegalArgumentException("Cannot delete product. Specify arguments rightly.");
        }
        String article = commandData[0];

        repository.delete(article);
        System.out.printf("Product with article #%s was successfully deleted.%n", article);
    }
}

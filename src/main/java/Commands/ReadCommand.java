package Commands;

import Repository.RepositoryImpl;

public class ReadCommand extends Commands {
    public ReadCommand(RepositoryImpl repository) {
        super(repository);
    }

    @Override
    public String name() {
        return "read";
    }

    @Override
    public void execute(String[] commandData) {
        if (commandData.length > 0) {
            throw new IllegalArgumentException("Cannot read products. Specify arguments rightly.");
        }
        repository.read();
    }
}

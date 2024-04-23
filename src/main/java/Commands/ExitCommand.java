package Commands;

import Repository.RepositoryImpl;

public class ExitCommand extends Commands {
    public ExitCommand(RepositoryImpl repository) {
        super(repository);
    }

    @Override
    public String name() {
        return "exit";
    }

    @Override
    public void execute(String[] commandData) {
        if (commandData.length > 0) {
            throw new IllegalArgumentException("Exit command shouldn't contain any arguments. Try again without them.");
        }
    }
}

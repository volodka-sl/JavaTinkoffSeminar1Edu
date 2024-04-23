package Commands;

import Repository.RepositoryImpl;

public abstract class Commands {
    public final RepositoryImpl repository;

    public Commands(RepositoryImpl repository) {
        this.repository = repository;
    }

    public abstract String name();
    public abstract void execute(String[] commandData);
}

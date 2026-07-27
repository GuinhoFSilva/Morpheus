package guinho.olympus.commands;

public interface Command {
    String name();

    void execute(String[] args);
}

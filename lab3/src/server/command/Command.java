package server.command;

public interface Command {
    String[] execute(String[] request) throws CommandException;
}

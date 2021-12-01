package server.command;

public class CommandException extends Exception {
    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }
}

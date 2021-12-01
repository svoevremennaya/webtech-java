package server.command.impl.record;

import server.command.Command;
import server.command.CommandException;
import server.dao.DaoException;
import server.dao.record.StudentRecordDaoFactory;

public class DeleteRecordCommandImpl implements Command {
    private static final byte REQUIRED_ARGUMENTS_COUNT = 2;

    @Override
    public String[] execute(String[] request) throws CommandException {
        if ((request == null) || (request.length < REQUIRED_ARGUMENTS_COUNT)) {
            throw new IllegalArgumentException("Not enough arguments");
        }

        try {
            StudentRecordDaoFactory.getDao().delete(request[0], request[1]);
            return null;
        } catch (DaoException e) {
            throw new CommandException("Error deleting record " + request[0] + ' ' + request[1], e);
        }
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}
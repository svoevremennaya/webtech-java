package server.command.impl.account;

import server.command.Command;
import server.command.CommandException;
import server.dao.DaoException;
import server.dao.account.AccountDaoFactory;

public class DoesAccountExistCommandImpl implements Command {
    private static final byte REQUIRED_ARGUMENTS_COUNT = 1;

    @Override
    public String[] execute(String[] request) throws CommandException {
        boolean result;

        if (request == null) {
            throw new IllegalArgumentException("Request shouldn't be null");
        }
        if (request.length < REQUIRED_ARGUMENTS_COUNT) {
            throw new IllegalArgumentException("Not enough arguments");
        }

        try {
            AccountDaoFactory.getDao().get(request[0]);
            result = true;
        } catch (DaoException e) {
            result = false;
        }
        return new String[] { Boolean.toString(result) };
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}

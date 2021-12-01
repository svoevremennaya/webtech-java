package server.command.impl.account;

import server.command.Command;
import server.command.CommandException;
import server.dao.DaoException;
import server.dao.account.AccountDaoFactory;

public class UpdateAccountStorageCommandImpl implements Command {
    @Override
    public String[] execute(String[] request) throws CommandException {
        try {
            AccountDaoFactory.getDao().updateInStorage();
            return null;
        } catch (DaoException e) {
            throw new CommandException("Error updating in storage", e);
        }
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}

package server.command.impl.record;

import server.command.Command;
import server.command.CommandException;
import server.dao.DaoException;
import server.dao.record.StudentRecordDaoFactory;

public class UpdateRecordStorageCommandImpl implements Command {
    @Override
    public String[] execute(String[] request) throws CommandException {
        try {
            StudentRecordDaoFactory.getDao().updateInStorage();
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

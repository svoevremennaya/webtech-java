package server.command.impl.record;

import domain.date.DateConverterFactory;
import domain.date.DateConvertionException;
import server.command.Command;
import server.command.CommandException;
import server.dao.DaoException;
import server.dao.record.StudentRecordDaoFactory;

public class UpdateRecordCommandImpl implements Command {
    private static final byte REQUIRED_ARGUMENTS_COUNT = 5;

    @Override
    public String[] execute(String[] request) throws CommandException {
        if ((request == null) || (request.length < REQUIRED_ARGUMENTS_COUNT)) {
            throw new IllegalArgumentException("Not enough arguments");
        }

        try {
            StudentRecordDaoFactory.getDao().update(Integer.parseInt(request[3]), request[1], request[0], request[4],
                    DateConverterFactory.getConverter().convert(request[2]));
            return null;
        } catch (DaoException e) {
            throw new CommandException("Error while updating record " + request[3] + ' ' + request[1], e);
        } catch (DateConvertionException e) {
            throw new IllegalArgumentException("Error converting date " + request[2]);
        }
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}

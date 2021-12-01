package server.command.impl.account;

import domain.account.UserRole;
import domain.password.DigestGeneratorFactory;
import domain.password.PasswordDigestException;
import server.command.Command;
import server.command.CommandException;
import server.dao.DaoException;
import server.dao.account.AccountDaoFactory;

public class UpdateAccountCommandImpl implements Command {
    private static final byte REQUIRED_ARGUMENTS_COUNT = 3;

    @Override
    public String[] execute(String[] request) throws CommandException {
        if (request == null) {
            throw new IllegalArgumentException("Request shouldn't be null");
        }
        if (request.length < REQUIRED_ARGUMENTS_COUNT) {
            throw new IllegalArgumentException("Not enough arguments");
        }

        try {
            AccountDaoFactory.getDao().update(request[0],
                    DigestGeneratorFactory.getPasswordDigestGenerator().generate(request[1]),
                    UserRole.valueOf(request[2]));
            return null;
        } catch (DaoException e) {
            throw new CommandException("Error updating account " + request[0], e);
        } catch (PasswordDigestException e) {
            throw new CommandException("Error creating account password digest", e);
        }
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}

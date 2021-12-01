package server.command.impl.account;

import domain.account.UserRole;
import domain.password.DigestGeneratorFactory;
import domain.password.PasswordDigestException;
import server.command.Command;
import server.command.CommandException;
import server.dao.DaoException;
import server.dao.account.AccountDao;
import server.dao.account.AccountDaoFactory;

public class AddAccountCommandImpl implements Command {
    private static final byte REQUIRED_ARGUMENTS_COUNT = 2;

    @Override
    public String[] execute(String[] request) throws CommandException {
        if (request == null) {
            throw new IllegalArgumentException("Request shouldn't be null");
        }
        if (request.length < REQUIRED_ARGUMENTS_COUNT) {
            throw new IllegalArgumentException("Not enough arguments");
        }

        try {
            AccountDao dao = AccountDaoFactory.getDao();

            dao.add(request[0], DigestGeneratorFactory.getPasswordDigestGenerator().generate(request[1]),
                    UserRole.USER);
            dao.updateInStorage();
            return null;
        } catch (DaoException e) {
            throw new CommandException("Error adding new account " + request[0], e);
        } catch (PasswordDigestException e) {
            throw new CommandException("Error generating password digest", e);
        }
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}

package server.dao.account;

import domain.account.Account;
import domain.account.UserRole;
import server.dao.Dao;
import server.dao.DaoException;

public interface AccountDao extends Dao<Account> {
    Account get(String username) throws DaoException;

    void delete(String username) throws DaoException;

    void update(String username, String password, UserRole role) throws DaoException;

    void add(String username, String password, UserRole role) throws DaoException;
}

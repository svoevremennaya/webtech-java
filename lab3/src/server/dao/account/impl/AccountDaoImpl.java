package server.dao.account.impl;

import domain.account.Account;
import domain.account.AccountFactory;
import domain.account.UserRole;
import server.dao.DaoException;
import server.dao.account.AccountDao;
import server.data.ReadWriteException;
import server.data.account.AccountReaderWriterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccountDaoImpl implements AccountDao {
    private List<Account> accounts;
    private String path;
    private final Object accountsModifySync;

    public AccountDaoImpl() {
        path = null;
        accounts = new ArrayList<>();
        accountsModifySync = new Object();
    }

    @Override
    public Account get(String username) throws DaoException {
        String trimmedUsername;

        if (username == null) {
            throw new IllegalArgumentException("Username shouldn't be null");
        }

        trimmedUsername = username.trim();

        if (trimmedUsername.isEmpty()) {
            throw new IllegalArgumentException("Username shouldn't be empty");
        }

        for (Account account : accounts) {
            if (account.getUsername().equals(trimmedUsername)) {
                return account;
            }
        }
        throw new DaoException("No user with username " + username);
    }

    @Override
    public void delete(String username) throws DaoException {
        String trimmedUsername;

        if (username == null) {
            throw new IllegalArgumentException("Username shouldn't be null");
        }

        trimmedUsername = username.trim();

        if (trimmedUsername.isEmpty()) {
            throw new IllegalArgumentException("Username shouldn't be empty");
        }

        synchronized (accountsModifySync) {
            for (Account account : accounts) {
                if (account.getUsername().equals(trimmedUsername)) {
                    accounts.remove(account);
                    return;
                }
            }
        }
        throw new DaoException("No user with username " + username);
    }

    @Override
    public void update(String username, String passwordHash, UserRole role) throws DaoException {
        String trimmedUsername, trimmedPasswordHash;

        if ((username == null) || (passwordHash == null) || (role == null)) {
            throw new IllegalArgumentException("Arguments shouldn't be null");
        }

        trimmedUsername = username.trim();
        trimmedPasswordHash = passwordHash.trim();

        if (trimmedUsername.isEmpty() || trimmedPasswordHash.isEmpty()) {
            throw new IllegalArgumentException("Arguments shouldn't be empty");
        }

        synchronized (accountsModifySync) {
            delete(trimmedUsername);
            add(trimmedUsername, trimmedPasswordHash, role);
        }
    }

    @Override
    public void add(String username, String passwordHash, UserRole role) throws DaoException {
        String trimmedUsername, trimmedPasswordHash;

        if ((username == null) || (passwordHash == null) || (role == null)) {
            throw new IllegalArgumentException("Arguments shouldn't be null");
        }

        trimmedUsername = username.trim();
        trimmedPasswordHash = passwordHash.trim();

        if (trimmedUsername.isEmpty() || trimmedPasswordHash.isEmpty()) {
            throw new IllegalArgumentException("Arguments shouldn't be empty");
        }

        synchronized (accountsModifySync) {
            for (Account account : accounts) {
                if (account.getUsername().equals(trimmedUsername)) {
                    throw new DaoException("User " + trimmedUsername + " already exists");
                }
            }
            accounts.add(AccountFactory.createAccount(trimmedUsername, trimmedPasswordHash, role));
        }
    }

    @Override
    public void loadFrom(String path) throws DaoException {
        String trimmedPath;

        if (path == null) {
            throw new IllegalArgumentException("Path shouldn't be null");
        }

        trimmedPath = path.trim();

        if (trimmedPath.isEmpty()) {
            throw new IllegalArgumentException("Path shouldn't be empty");
        }

        try {
            synchronized (accountsModifySync) {
                accounts = AccountReaderWriterFactory.getReaderWriter().readFrom(trimmedPath);
                this.path = trimmedPath;
            }
        } catch (ReadWriteException e) {
            throw new DaoException("Error loading from " + path, e);
        }
    }

    @Override
    public void updateInStorage() throws DaoException {
        if (path == null) {
            throw new DaoException("Never loaded");
        }

        try {
            synchronized (accountsModifySync) {
                AccountReaderWriterFactory.getReaderWriter().writeTo(accounts, path);
            }
        } catch (ReadWriteException e) {
            throw new DaoException("Error updating into " + path, e);
        }
    }

    @Override
    public List<Account> getAll() {
        return new ArrayList<>(accounts);
    }

    @Override
    public boolean equals(Object o) {
        AccountDaoImpl toCompare;

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        toCompare = (AccountDaoImpl) o;
        return Objects.equals(accounts, toCompare.accounts) && Objects.equals(path, toCompare.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accounts, path);
    }

    @Override
    public String toString() {
        return getClass().getName() + "@accounts: " + accounts + ", path: " + path;
    }
}

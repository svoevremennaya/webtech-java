package server.dao.account;

import server.dao.account.impl.AccountDaoImpl;

public class AccountDaoFactory {
    private static final AccountDao accountDao = new AccountDaoImpl();

    public static AccountDao getDao() {
        return accountDao;
    }

    private AccountDaoFactory() {
    }
}

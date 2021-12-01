package domain.account;

import domain.account.impl.ImmutableAccountImpl;
import domain.account.impl.SerializableAccountImpl;

public class AccountFactory {
    public static Account createAccount(String username, String passwordHash, UserRole role) {
        return new ImmutableAccountImpl(username, passwordHash, role);
    }

    public static Account createSerializableAccount(Account account) {
        return createSerializableAccount(account.getUsername(), account.getPasswordHash(), account.getRole());
    }

    public static Account createSerializableAccount(String username, String passwordHash, UserRole role) {
        return new SerializableAccountImpl(username, passwordHash, role);
    }

    private AccountFactory() {
    }
}

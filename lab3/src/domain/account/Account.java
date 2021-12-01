package domain.account;

public interface Account {
    String getUsername();

    String getPasswordHash();

    UserRole getRole();
}
